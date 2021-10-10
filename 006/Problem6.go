package main

import (
	"fmt"
	"time"
)

func sumOfSquares(num int) int {
	sum := 0
	for num > 0 {
		sum += num * num
		num--
	}
	return sum
}

func squareOfSum(num int) int {
	sum := 0
	for num > 0 {
		sum += num
		num--
	}
	return sum * sum
}

func problem005() {
	naturalNum := 100
	fmt.Println(squareOfSum(naturalNum) - sumOfSquares(naturalNum))
}

func main() {
	start := time.Now()
	problem005()
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
