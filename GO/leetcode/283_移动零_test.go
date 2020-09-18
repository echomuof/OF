package leetcode

import "testing"

func TestMoveZero(t *testing.T) {
	nums := []int{0, 1, 0, 3, 12}
	moveZeroes(nums)
	t.Logf("%v", nums)
}

func moveZeroes(nums []int) {
	k := 0
	for i, num := range nums {
		if num != 0 {
			nums[k], nums[i] = num, nums[k]
			k++
		}
	}
}
