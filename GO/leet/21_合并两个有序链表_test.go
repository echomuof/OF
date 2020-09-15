package leet

import (
	"testing"
)

func TestMerge(t *testing.T) {
	node3 := ListNode{
		Val: 4,
	}

	node2 := ListNode{
		Val:  2,
		Next: &node3,
	}

	node1 := ListNode{
		Val:  1,
		Next: &node2,
	}

	node6 := ListNode{
		Val: 4,
	}

	node5 := ListNode{
		Val:  3,
		Next: &node6,
	}

	node4 := ListNode{
		Val:  1,
		Next: &node5,
	}
	node := mergeTwoLists2(&node1, &node4)
	for node != nil {
		t.Logf("%d", node.Val)
		node = node.Next
	}
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	if l1.Val < l2.Val {
		l1.Next = mergeTwoLists(l1.Next, l2)
		return l1
	} else {
		l2.Next = mergeTwoLists(l1, l2.Next)
		return l2
	}
}

func mergeTwoLists2(l1 *ListNode, l2 *ListNode) *ListNode {
	pHead := &ListNode{}
	res := pHead
	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			pHead.Next = l1
			l1 = l1.Next
		} else {
			pHead.Next = l2
			l2 = l2.Next
		}
		pHead = pHead.Next
	}
	if l1 != nil {
		pHead.Next = l1
	}
	if l2 != nil {
		pHead.Next = l2
	}
	return res.Next
}
