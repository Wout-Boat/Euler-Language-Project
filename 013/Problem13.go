package main

import (
	"bufio"
	"fmt"
	"math/big"
	"os"
	"time"
)

func readLines(path string) ([]string, error) {
	file, err := os.Open(path)
	if err != nil {
		return nil, err
	}
	defer file.Close()

	var lines []string
	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		lines = append(lines, scanner.Text())
	}
	return lines, scanner.Err()
}

func problem() {
	var lines, err = readLines("numbers.txt")

	if err != nil {
		fmt.Println("Read Lines Error")
		os.Exit(2)
	}
	num := big.NewInt(0)

	for i := 0; i < len(lines); i++ {
		x := new(big.Int)
		x, ok := x.SetString(lines[i], 10)

		if !ok {
			fmt.Println("Set String Error")
			os.Exit(1)
		}

		num = num.Add(num, x)
	}

	numString := num.String()

	for i := 0; i < 10; i++ {
		fmt.Print(string(numString[i]))
	}

	fmt.Println()
}

func main() {
	start := time.Now()
	problem()
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
