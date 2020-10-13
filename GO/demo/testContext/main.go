package main

import (
	"context"
	"fmt"
	"sync"
	"time"
)

var wg sync.WaitGroup

func main() {
	ctx, cancelFunc := context.WithCancel(context.Background())
	go work(ctx)
	time.Sleep(time.Second * 5)
	cancelFunc()
	wg.Wait()
	fmt.Println("over")
}

func work(ctx context.Context) {
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
