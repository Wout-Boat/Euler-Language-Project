package main

import (
	"fmt"
	"time"
)

func collatzCount(n int) int {
	count := 0
	for n > 1 {
		count++
		if n%2 != 0 {
			n = 3*n + 1
		} else {
			n = n / 2
		}
	}
	count++
	return count
}

func problem() {
	num := 0
	max := 0
	for i := 2; i < 1_000_000; i++ {
		tmp := collatzCount(i)
		if tmp > max {
			max = tmp
			num = i
		}
	}
	fmt.Println(num)
}

func main() {
	start := time.Now()
	problem()
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
