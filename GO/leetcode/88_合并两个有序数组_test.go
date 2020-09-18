package leetcode

import (
	"testing"
)

func TestMergeArray(t *testing.T) {
	nums1 := []int{2, 0}
	nums2 := []int{1}
	m := 1
	n := 1
	merge(nums1, m, nums2, n)
	t.Logf("%v", nums1)
}

func merge(nums1 []int, m int, nums2 []int, n int) {
	nums1Copy := make([]int, m)
	copy(nums1Copy, nums1)
	p1, p2, p := 0, 0, 0
	for p1 < m && p2 < n {
		if nums1Copy[p1] <= nums2[p2] {
			nums1[p] = nums1Copy[p1]
			p1++
		} else {
			nums1[p] = nums2[p2]
			p2++
		}
		p++
	}
	if p1 < m {
		nums1 = append(nums1[:p], nums1Copy[p1:]...)
	}
	if p2 < n {
		nums1 = append(nums1[:p], nums2[p2:]...)
	}
}
