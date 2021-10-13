package main

import (
	"fmt"
	"time"
)

func problem() {
	gridSize := 20
	paths := 1
	for i := 0; i < gridSize; i++ {
		paths *= (2 * gridSize) - i
		paths /= i + 1
	}
	fmt.Println(paths)
}

func main() {
	start := time.Now()
	problem()
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
