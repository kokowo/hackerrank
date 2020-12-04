package yush.data.linkedlist;

/*
 * Question:
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes 
 * contains a single digit. Add the two numbers and return it as a linked list.
 */
public class AddTwoNumber {
	public SingleLinkedListNode addTwoNumbers(SingleLinkedListNode l1, SingleLinkedListNode l2) {
		SingleLinkedListNode dummyHead = new SingleLinkedListNode(0);
		SingleLinkedListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int digit = carry + x + y;
			carry = digit / 10;
			curr.next = new SingleLinkedListNode(digit % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new SingleLinkedListNode(carry);
		}
		return dummyHead.next;
	}
}
