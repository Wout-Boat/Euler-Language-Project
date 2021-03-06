package main

import (
	"fmt"
	"time"
)

// Prime factorization of a given number
//
// A map is returned.
//
//   key of map: prime
//   value of map: prime exponents
//
func PrimeFactorization(n int) (pfs map[int]int) {
	pfs = make(map[int]int)

	// Get the number of 2s that divide n
	for n%2 == 0 {
		if _, ok := pfs[2]; ok {
			pfs[2] += 1
		} else {
			pfs[2] = 1
		}
		n = n / 2
	}

	// n must be odd at this point. so we can skip one element
	// (note i = i + 2)
	for i := 3; i*i <= n; i = i + 2 {
		// while i divides n, append i and divide n
		for n%i == 0 {
			if _, ok := pfs[i]; ok {
				pfs[i] += 1
			} else {
				pfs[i] = 1
			}
			n = n / i
		}
	}

	// This condition is to handle the case when n is a prime number
	// greater than 2
	if n > 2 {
		pfs[n] = 1
	}

	return
}

// Calculate number of divisors of a given number
func NumberOfDivisors(n int) int {
	pfs := PrimeFactorization(n)

	num := 1
	for _, exponents := range pfs {
		num *= (exponents + 1)
	}

	return num
}

func problem() {
	numDivisors := 500
	i := 3
	for {
		key := i
		sum := 0
		for i > 0 {
			sum += i
			i--
		}
		if NumberOfDivisors(sum) > numDivisors {
			fmt.Println(sum)
			break
		}
		i = key + 1
	}
}

func main() {
	start := time.Now()
	problem()
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
