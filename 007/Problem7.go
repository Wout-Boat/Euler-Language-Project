package main

import (
	"fmt"
	"time"
)

func slowPrime(num int) bool {
	for i := 2; i < num; i++ {
		if num%i == 0 {
			return false
		}
	}
	return true
}

func problem() {
	count := 2
	i := 4
	for {
		i++
		if slowPrime(i) {
			count++
			if count == 10_001 {
				break
			}
		}
	}
	fmt.Println(i)
}

func main() {
	start := time.Now()
	for i := 0; i < 100; i++ {
		problem()
	}
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
