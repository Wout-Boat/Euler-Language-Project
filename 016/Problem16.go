package main

import (
	"fmt"
	"math/big"
	"time"
)

func problem() {
	var two, thousand = big.NewInt(2), big.NewInt(1000)
	var number = two.Exp(two, thousand, nil)
	ten := big.NewInt(10)
	s := big.NewInt(0)
	mod := big.NewInt(0)
	for ten.Cmp(number) < 0 {
		s.Add(s, mod.Mod(number, ten))
		number.Div(number, ten)
	}
	s.Add(s, number)
	fmt.Println(s.String())
}

func main() {
	start := time.Now()
	problem()
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
