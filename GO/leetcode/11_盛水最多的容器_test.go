package leetcode

import "testing"

func TestMaxArea(t *testing.T) {
	arr := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	t.Logf("%d", getMaxArea(arr))
}

func getMaxArea(arr []int) int {
	L := 0
	R := len(arr) - 1
	maxArea := 0
	for L < R {
		var minHeight int
		if arr[L] <= arr[R] {
			minHeight = arr[L]
			L++
		} else {
			minHeight = arr[R]
			R--
		}
		curArea := minHeight * (R - L + 1)
		if curArea > maxArea {
			maxArea = curArea
		}
	}
	return maxArea
}
