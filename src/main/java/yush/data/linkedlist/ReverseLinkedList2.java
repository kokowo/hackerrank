package yush.data.linkedlist;

// input list = [1, 2, 8, 9, 12, 16]
// output 		[1, 8, 2, 9, 16, 12]
// only reverse the event sublist
public class ReverseLinkedList2 {
	class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	Node reverse(Node head) {
		// Write your code here
		Node dummy = new Node(0);

		Node cur = head;
		Node newhead = dummy;
		while (cur != null) {
			if (cur.data % 2 != 0) {
				newhead.next = cur;
				newhead = cur;
				cur = cur.next;
			} else {
				Node start = cur;
				Node end = cur;
				cur = cur.next;
				Node next;

				while (cur != null && cur.data % 2 == 0) {
					next = cur.next;
					cur.next = end;
					end = cur;
					cur = next;
				}

				newhead.next = end;
				newhead = start;

			}
			newhead.next = null;

		}
		return dummy.next;

	}
}
