package yush.data.linkedlist;

import java.util.HashSet;

public class DetectLoop {

	// extra storage
	public boolean detectLoop1(SingleLinkedListNode h) {
		HashSet<SingleLinkedListNode> s = new HashSet<SingleLinkedListNode>();
		while (h != null) {
			if (s.contains(h))
				return true;
			s.add(h);
			h = h.next;
		}

		return false;
	}

	// Floyd’s Cycle-Finding Algorithm
	public boolean detectLoop2(SingleLinkedListNode head) {
		SingleLinkedListNode slow_p = head, fast_p = head;
		while (slow_p != null && fast_p != null && fast_p.next != null) {
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if (slow_p == fast_p) {
				return true;
			}
		}
		return false;
	}

	// modify next pointer t indicate it's visited
	public boolean detectLoop3(SingleLinkedListNode head) {
		// Create a temporary node
		SingleLinkedListNode temp = new SingleLinkedListNode(-1);
		while (head != null) {
			if (head.next == null) {
				return false;
			}
			if (head.next == temp) {
				return true;
			}
			SingleLinkedListNode nex = head.next;
			head.next = temp;
			head = nex;
		}

		return false;
	}
}
