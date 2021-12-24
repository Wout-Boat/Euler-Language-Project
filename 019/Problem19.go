package main

import (
	"fmt"
	"time"
)

// Calculates the number of Sundays between two dates
func sundays(start, end time.Time) int {
	var sundays int
	for start.Before(end) {
		if start.Weekday() == time.Sunday && (int(start.Day())) == 1 {
			sundays++
		}
		start = start.AddDate(0, 0, 1)
	}
	return sundays
}

func problem() {
	value1 := "Thu, 01/01/1901"
	layout := "Mon, 01/02/2006"
	t1, _ := time.Parse(layout, value1)

	value2 := "Sun, 12/31/2000"
	t2, _ := time.Parse(layout, value2)

	fmt.Println(sundays(t1, t2))
}

func main() {
	start := time.Now()
	problem()
	elapsed := time.Since(start)
	fmt.Printf("Function took %s", elapsed)
}
