package leet

import "testing"

func TestCircle2(t *testing.T) {

}

func detectCycle(head *ListNode) *ListNode {
	s := head
	f := head
	for true {
		if f == nil || f.Next == nil {
			return nil
		}
		s = s.Next
		f = f.Next.Next
		if s == f {
			break
		}
	}
	s = head
	for s != f {
		s = s.Next
		f = f.Next
	}
	return s
}
