/**
 *
 * @author: echomuof
 * @created: 2020/11/25
 */
package leetcode

import "testing"

func TestTwoSum(t *testing.T) {
	nums := []int{2, 7, 11, 15}
	t.Log(twoSum(nums, 9))
}

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, v := range nums {
		cur := target - v
		if _, ok := m[cur]; ok {
			return []int{i, m[cur]}
		}
		m[v] = i
	}
	return []int{}
}
