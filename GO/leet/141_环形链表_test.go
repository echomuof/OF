package leet

import "testing"

func TestHasCircle(t *testing.T) {

}

func hasCycle(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return false
	}
	p1 := head
	p2 := head.Next
	for p2 != nil && p2.Next != nil {
		if p1.Val == p2.Val {
			return true
		}
		p1, p2 = p1.Next, p2.Next.Next
	}
	return false
}
