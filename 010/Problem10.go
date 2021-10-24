package main

import (
	"fmt"
	"time"
)

func SieveOfEratosthenes(n int) []bool {
	integers := make([]bool, n+1)
	for i := 2; i < n+1; i++ {
		integers[i] = true
	}

	for p := 2; p*p <= n; p++ {
		if integers[p] == true {
			for i := p * 2; i <= n; i += p {
				integers[i] = false
			}
		}
	}

	return integers
}

func problem() {
	n := 200
	arr := SieveOfEratosthenes(n)

	sum := 0
	for i := 1; i < n; i++ {
		if arr[i] {
			sum += i
		}
	}

	fmt.Println(sum)
}

func main() {
	start := time.Now()
	for i := 0; i < 1000; i++ {
		problem()
	}
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
