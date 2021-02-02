package main

import (
	"context"
	"fmt"
	"io/ioutil"
	"net/http"
	"sync"
	"time"
)

var wg sync.WaitGroup

func main() {
	resp, err := http.Get("https://yz.chsi.com.cn/apply/kscx/zkzdown.do?bmh=220782139&trnd=7942a4b9-b2e9-4076-8a27-c938d27c8749")
	if err != nil {
		fmt.Printf("%v", err)
	}
	bytes, err := ioutil.ReadAll(resp.Body)
	fmt.Println(string(bytes))
}

func wok(ctx context.Context) {
LOOP:
	for {
		fmt.Println("working......")
		go works(ctx)
		time.Sleep(time.Second)
		select {
		case <-ctx.Done():
			break LOOP
		default:
		}
	}
	wg.Done()
}

func works(ctx context.Context) {
LOOP:
	for true {
		fmt.Println("work2......")
		time.Sleep(500 * time.Millisecond)
		select {
		case <-ctx.Done():
			break LOOP
		default:
		}
	}
}
