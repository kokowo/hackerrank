package yush.data.linkedlist;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.
 */
public class SwapNodesInPairs {
	public SingleLinkedListNode swapPairs(SingleLinkedListNode head) {
		SingleLinkedListNode dummy = new SingleLinkedListNode(0);
		dummy.next = head;
		SingleLinkedListNode p = head;
		SingleLinkedListNode prev = dummy;
		while (p != null && p.next != null) {
			SingleLinkedListNode q = p.next, r = p.next.next;
			prev.next = q;
			q.next = p;
			p.next = r;
			prev = p;
			p = r;
		}
		return dummy.next;
	}
}
