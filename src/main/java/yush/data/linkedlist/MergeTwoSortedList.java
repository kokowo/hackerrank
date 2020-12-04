package yush.data.linkedlist;

import java.util.List;

/*
 * Question:
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedList {

	// divide and conquer to merge k sorted list
	public SingleLinkedListNode mergeKLists(List<SingleLinkedListNode> lists) {
		if (lists.isEmpty())
			return null;
		int end = lists.size() - 1;
		while (end > 0) {
			int begin = 0;
			while (begin < end) {
				lists.set(begin, mergeTwoLists(lists.get(begin), lists.get(end)));
				begin++;
				end--;
			}
		}
		return lists.get(0);
	}

	public SingleLinkedListNode mergeTwoLists(SingleLinkedListNode l1, SingleLinkedListNode l2) {
		SingleLinkedListNode dummyHead = new SingleLinkedListNode(0);
		SingleLinkedListNode p = dummyHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 != null)
			p.next = l1;
		if (l2 != null)
			p.next = l2;
		return dummyHead.next;
	}
}
