package main

import (
	"fmt"
	"math/big"
	"strconv"
	"time"
)

func problem() {
	// Starting number
	startNum := int64(100)

	a := startNum
	prod := big.NewInt(1)
	for a > 1 {
		prod.Mul(prod, big.NewInt(a))
		a--
	}
	ansString := prod.String()
	sum := 0
	for i := 0; i < len(ansString); i++ {
		tmp, _ := strconv.Atoi(string(ansString[i]))
		sum += tmp
	}
	fmt.Println(sum)
}

func main() {
	numLoops := 1000
	start := time.Now()
	for i := 0; i < numLoops; i++ {
		problem()
	}
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
