package 剑指offer

import (
	"GO/leetcode"
	"testing"
)

func TestReverseList(t *testing.T) {

}

func reverseList(head *leetcode.ListNode) *leetcode.ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	newHead := reverseList(head.Next)
	head.Next.Next = head
	head.Next = nil
	return newHead
}

func reverseList2(head *leetcode.ListNode) *leetcode.ListNode {
	cur := head
	var newHead *leetcode.ListNode = nil
	for cur != nil {
		tmp := cur.Next
		cur.Next = newHead
		newHead = cur
		cur = tmp
	}
	return newHead
}
