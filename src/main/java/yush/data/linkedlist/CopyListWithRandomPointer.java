package yush.data.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*
 * A linked list is given such that each node contains an additional random pointer that could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
*/
public class CopyListWithRandomPointer {

	// nice and hard way
	// node.next.random = node.random.next
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode p = head;
		while (p != null) {
			RandomListNode next = p.next;
			RandomListNode copy = new RandomListNode(p.label);
			p.next = copy;
			copy.next = next;
			p = next;
		}
		p = head;
		while (p != null) {
			p.next.random = (p.random != null) ? p.random.next : null;
			p = p.next.next;
		}
		p = head;
		RandomListNode headCopy = (p != null) ? p.next : null;
		while (p != null) {
			RandomListNode copy = p.next;
			p.next = copy.next;
			p = p.next;
			copy.next = (p != null) ? p.next : null;
		}
		return headCopy;
	}

	public RandomListNode copyRandomListHash(RandomListNode head) {
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode p = head;
		RandomListNode dummy = new RandomListNode("");
		RandomListNode q = dummy;
		while (p != null) {
			q.next = new RandomListNode(p.label);
			map.put(p, q.next);
			p = p.next;
			q = q.next;
		}
		p = head;
		q = dummy;
		while (p != null) {
			q.next.random = map.get(p.random);
			p = p.next;
			q = q.next;
		}
		return dummy.next;
	}

	static class RandomListNode {
		public RandomListNode(String l) {
			this.label = l;
		}

		String label;
		RandomListNode next;
		RandomListNode random;
	}
}
