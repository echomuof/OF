package leet

import "testing"

func TestReverseList(t *testing.T) {

}

func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	newHead := reverseList(head.Next)
	head.Next.Next = head
	head.Next = nil
	return newHead
}

func reverseList2(head *ListNode) *ListNode {
	cur := head
	var newHead *ListNode = nil
	for cur != nil {
		tmp := cur.Next
		cur.Next = newHead
		newHead = cur
		cur = tmp
	}
	return newHead
}
