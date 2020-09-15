package leet

import "testing"

func TestFib(t *testing.T) {
	t.Logf("%d", fib(4))
}

func fib(n int) int {
	if n < 2 {
		return n
	}
	a, b := 0, 1
	c := a + b
	for n > 2 {
		a, b = b, c
		c = a + b
		n--
	}
	return c
}
