package leetcode

import "testing"

func TestRotate(t *testing.T) {
	nums := []int{1, 2, 3, 4, 5, 6, 7}
	rotate(nums, 3)
	t.Logf("%v", nums)
}

func rotate(nums []int, k int) {
	help := make([]int, len(nums))
	for i, num := range nums {
		help[(i+k)%len(nums)] = num
	}
	for i, he := range help {
		nums[i] = he
	}
}
