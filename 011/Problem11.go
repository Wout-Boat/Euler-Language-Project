package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
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

// This function finds the maximum product of any vertical set of length l numbers in the grid
func vertMaxProduct(grid [][]int, l int) int {
	max := 0
	m := 20
	product := 1
	for i := 0; i < l+1; i++ {
		for j := 0; j < m; j++ {
			product = 1
			for k := 1; k < l; k++ {
				product *= grid[i+k][j]
			}
			if product > max {
				max = product
			}
		}
	}
	return max
}

func horzMaxProduct(grid [][]int, l int) int {
	max := 0
	n := 20
	m := 20
	product := 1
	for i := 0; i < n; i++ {
		for j := 0; j < m-l+1; j++ {
			product = 1
			subset := grid[i][j : j+l]
			for k := 1; k < len(subset); k++ {
				product *= subset[k]
			}
			if product > max {
				max = product
			}
		}
	}
	return max
}

func diagAProduct(grid [][]int, l int) int {
	answer := 0
	n := 20
	m := 20
	product := 1
	for i := 0; i < n-l+1; i++ {
		for j := 0; j < m-l+1; j++ {
			product = 1
			for k := 0; k < l; k++ {
				product *= grid[i+k][j+k]
			}
			if product > answer {
				answer = product
			}
		}
	}
	return answer
}

func diagBProduct(grid [][]int, l int) int {
	answer := 0
	n := 20
	m := 20
	product := 1
	for i := l - 1; i < n; i++ {
		for j := 0; j < m-l+1; j++ {
			product = 1
			for k := 0; k < l; k++ {
				product *= grid[i-k][j+k]
			}
			if product > answer {
				answer = product
			}
		}
	}
	return answer
}

func findGreatest(grid [][]int, length int) int {
	var tmp int
	var max int = vertMaxProduct(grid, length)
	tmp = horzMaxProduct(grid, length)
	if tmp > max {
		max = tmp
	}
	tmp = diagAProduct(grid, length)
	if tmp > max {
		max = tmp
	}
	tmp = diagBProduct(grid, length)
	if tmp > max {
		max = tmp
	}
	return max
}

func problem() {
	// Open grid.txt as file
	var lines, err = readLines("grid.txt")

	if err != nil {
		fmt.Println(err)
		os.Exit(2)
	}

	// Create two-dimensional slice
	grid := make([][]int, 20)
	for i := 0; i < 20; i++ {
		grid[i] = make([]int, 20)
	}

	// Read file contents into 2d slice
	for i := 0; i < 20; i++ {
		s := strings.Fields(lines[i])
		for j := 0; j < 20; j++ {
			grid[i][j], _ = strconv.Atoi(s[j])
		}
	}

	fmt.Println(findGreatest(grid, 4))

}

func main() {
	start := time.Now()
	problem()
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
