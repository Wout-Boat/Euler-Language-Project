package main

import (
	"fmt"
	"strings"
	"time"
)

var ones = [...]string{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}
var teens = [...]string{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"}
var tens = [...]string{"", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"}

func numToString(num int) string {
	if num == 1000 {
		return "OneThousand"
	}
	if num < 10 {
		return ones[num-1]
	}

	var output strings.Builder

	if num >= 100 {
		hundredsSpot := num / 100
		remainder := num % 100
		output.WriteString(ones[hundredsSpot-1])
		output.WriteString("Hundred")
		if remainder == 0 {
			return output.String()
		}
		output.WriteString("And")
		num = remainder
	} // End Hundreds

	if num >= 10 {
		if num < 20 {
			output.WriteString(teens[num-10])
			return output.String()
		}
		tensSpot := num / 10
		remainder := num % 10
		output.WriteString(tens[tensSpot-1])
		num = remainder
		if num == 0 {
			return output.String()
		}
	} // End Tens

	output.WriteString(ones[num-1])
	return output.String()
}

func NumLength(num int) int {
	return len(numToString(num))
}

func problem() {
	var sum = 0
	for i := 1; i < 1001; i++ {
		sum += NumLength(i)
	}
	fmt.Println(sum)
}

func main() {
	start := time.Now()
	problem()
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
