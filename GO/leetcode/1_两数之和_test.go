package leetcode

import "testing"

func TestTwoSum(t *testing.T) {
	nums := []int{2, 7, 11, 15}
	target := 9
	res := TwoSum(nums, target)
	t.Logf("%v", res)
}

func TwoSum(nums []int, target int) []int {
	numsMap := make(map[int]int)
	for i, value := range nums {
		if v, ok := numsMap[target-value]; ok {
			return []int{i, v}
		}
		numsMap[value] = i
	}
	return []int{}
}
