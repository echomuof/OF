package leet

import "testing"

func TestReverseKGroup(t *testing.T) {

}

func reverseKGroup(head *ListNode, k int) *ListNode {
	newHead := new(ListNode)
	newHead.Next = head
	pre := newHead
	end := newHead
	for end.Next != nil {
		for i := 0; i < k && end != nil; i++ {
			end = end.Next
		}
		if end == nil {
			break
		}
		start := pre.Next
		next := end.Next
		end.Next = nil
		pre.Next = reverse(start)
		start.Next = next
		pre = start
		end = pre
	}
	return newHead.Next
}

func reverse(head *ListNode) *ListNode {
	var pre *ListNode
	cur := head
	for cur != nil {
		next := cur.Next
		cur.Next = pre
		pre = cur
		cur = next
	}
	return pre
}
