package leetcode

import "testing"

func TestClimb(t *testing.T) {
	t.Logf("%d", climbStairs(3))
}

func climbStairs(n int) int {
	i, a, b, c := 0, 0, 0, 1
	for i < n {
		a = b
		b = c
		c = a + b
		i++
	}
	return c
}
