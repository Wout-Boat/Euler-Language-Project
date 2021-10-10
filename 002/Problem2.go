package main

import (
	"fmt"
	"time"
)

func problem002() {
	var a, b, sum int = 1, 2, 2
	var c int

	for c < 4_000_000 {
		c = a + b
		if c%2 == 0 {
			sum += c
		}
		a = b
		b = c
	}

	fmt.Println(sum)
}

func main() {
	start := time.Now()
	problem002()
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
