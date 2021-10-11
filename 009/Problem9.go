package main

import (
	"fmt"
	"time"
)

func problem() {
	var a, b int
	c, s, found := 0, 1000, false
	for a = 1; a < s/3; a++ {
		for b = a; b < s/2; b++ {
			c = s - a - b

			if a*a+b*b == c*c {
				found = true
				break
			}
		}
		if found {
			break
		}
	}
	fmt.Println(a * b * c)
}

func main() {
	start := time.Now()
	problem()
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
