package leetcode

import (
	"testing"
)

func TestSwapListNode(t *testing.T) {
	n4 := &ListNode{
		Val: 4,
	}

	n3 := &ListNode{
		Val:  3,
		Next: n4,
	}

	n2 := &ListNode{
		Val:  2,
		Next: n3,
	}

	n1 := &ListNode{
		Val:  1,
		Next: n2,
	}

	node := swapListNode(n1)
	for node != nil {
		t.Logf("%d", node.Val)
		node = node.Next
	}
}

func swapListNode(head *ListNode) *ListNode {
	pre := &ListNode{0, head}
	tmp := pre
	for tmp.Next != nil && tmp.Next.Next != nil {
		start := tmp.Next
		end := tmp.Next.Next
		tmp.Next = end
		start.Next = end.Next
		end.Next = start
		tmp = start
	}
	return pre.Next
}
