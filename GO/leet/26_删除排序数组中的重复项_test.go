package leet

import "testing"

func TestRemoveDuplicates(t *testing.T) {
	nums := []int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
	len := removeDuplicates2(nums)
	t.Logf("%v", nums[0:len])
}

func removeDuplicates(nums []int) int {
	size := 0
	for i, num := range nums {
		if i > 0 && num > nums[i-1] {
			size++
			nums[size] = num
		}
	}
	return size + 1
}

func removeDuplicates2(nums []int) int {
	p1 := 0
	p2 := 1
	for p1 < len(nums) && p2 < len(nums) {
		if nums[p2] == nums[p1] {
			p2++
		} else if nums[p2] > nums[p1] {
			p1++
			nums[p1] = nums[p2]
			p2++
		}
	}
	return p1 + 1
}
