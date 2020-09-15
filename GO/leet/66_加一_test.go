package leet

import "testing"

func TestPlusOne(t *testing.T) {
	digits := []int{9, 9, 9, 9}
	t.Logf("%v", plusOne(digits))
}

func plusOne(digits []int) []int {
	digits[len(digits)-1]++
	for i := len(digits) - 1; i > 0; i-- {
		if digits[i] >= 10 {
			digits[i] %= 10
			digits[i-1]++
		}
	}
	var res []int
	if digits[0] >= 10 {
		res = make([]int, 1)
		res[0] = 1
		digits = make([]int, len(digits))
		res = append(res, digits...)
	} else {
		res = digits
	}
	return res
}
