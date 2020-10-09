package main

import (
	"log"
	"net"
	"os"
	"runtime"
	"time"
)

type Client struct {
	c    chan string
	name string
	addr string
}

var messageChan = make(chan string)

var onlineMap map[string]Client

func main() {

	listener, err := net.Listen("tcp", ":9090")
	if err != nil {
		log.Fatalf("服务器监听连接错误：%v", err)
		os.Exit(1)
	}
	defer listener.Close()
	go manager()
	for true {
		conn, err := listener.Accept()
		if err != nil {
			log.Fatalf("客户端连接错误：%v", err)
			continue
		}
		go handlerConn(conn)
	}

}

func handlerConn(conn net.Conn) {
	defer conn.Close()
	addr := conn.RemoteAddr().String()
	curCli := Client{
		c:    make(chan string),
		name: addr,
		addr: addr,
	}
	onlineMap[addr] = curCli
	go writeMsg2Cli(curCli, conn)
	messageChan <- makeMsg(curCli, "上线了")
	isQuit := make(chan bool)
	hasData := make(chan bool)
	go func() {
		buf := make([]byte, 1024)
		for true {
			n, err := conn.Read(buf)
			if n == 0 {
				log.Printf("检测到%s退出", curCli.name)
				isQuit <- true
				runtime.Goexit()
			}
			if err != nil {
				log.Fatalf("接收消息失败：%v", err)
				continue
			}
			msg := string(buf[:n-1])
			messageChan <- makeMsg(curCli, msg)
			hasData <- true
		}
	}()
	for true {
		select {
		case <-isQuit:
			messageChan <- makeMsg(curCli, "退出登录")
		case <-hasData:
		case <-time.After(30 * time.Second):
			messageChan <- makeMsg(curCli, "超时退出")
			delete(onlineMap, addr)
			runtime.Goexit()
		}
	}
}

func manager() {
	onlineMap = make(map[string]Client)
	for true {
		msg := <-messageChan
		for _, client := range onlineMap {
			client.c <- msg
		}
	}
}

func writeMsg2Cli(cli Client, conn net.Conn) {
	for msg := range cli.c {
		_, err := conn.Write([]byte(msg))
		if err != nil {
			log.Fatalf("发送消息失败：%v", err)
			return
		}
	}
}

func makeMsg(client Client, msg string) string {
	return "[" + client.addr + "]" + client.name + ": " + msg + "\n"
}
