package main

import (
	"fmt"
	"time"
)

func problem001() {
	var sum int = 0
	for i := 1; i < 1000; i++ {
		if i%3 == 0 || i%5 == 0 {
			sum += i
		}
	}
	fmt.Println(sum)
}

func main() {
	start := time.Now()
	for i := 0; i < 10000; i++ {
		problem001()
	}
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
