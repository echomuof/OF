package leet

import (
	"sort"
	"testing"
)

func TestThreeSum(t *testing.T) {
	nums := []int{-1, 0, 1, 2, -1, -4}
	t.Logf("%v", threeSum(nums))
}

func threeSum(nums []int) [][]int {
	res := [][]int{}
	sort.Ints(nums)
	for i, num := range nums {
		if num > 0 {
			break
		}
		if i > 0 && num == nums[i-1] {
			continue
		}
		L := i + 1
		R := len(nums) - 1
		for L < R {
			cur := num + nums[L] + nums[R]
			if cur == 0 {
				res = append(res, []int{num, nums[L], nums[R]})
				for L < R && nums[L] == nums[L+1] {
					L++
				}
				for L < R && nums[R] == nums[R-1] {
					R--
				}
				L++
				R--
			} else if cur < 0 {
				L++
			} else {
				R--
			}
		}
	}
	return res
}
