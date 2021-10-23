package main

import (
	"fmt"
	"time"
)

// reverse_int reverses the order of all the numbers in an integer. It does not perform any type changes and returns a reversed integer.
func reverse_int(n int) int {
	new_int := 0
	for n != 0 {
		remainder := n % 10
		new_int *= 10
		new_int += remainder
		n /= 10
	}
	return new_int
}

func problem() {
	var max int = 0
	var prod int
	for i := 100; i < 1000; i++ {
		for j := 100; j < 1000; j++ {
			prod = i * j
			if prod == reverse_int(prod) && prod > max {
				max = prod
			} // End if
		} // End inner for
	} // End outer for
	fmt.Println(max)
}

func main() {
	start := time.Now()
	for i := 0; i < 1000; i++ {
		problem()
	}
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
