package yush.data.linkedlist;


/*
 * Reverse singly linked list without using three pointers. You can use only two pointers.
 */
public class ReverseSll {

	public SingleLinkedListNode reverseSll(SingleLinkedListNode root) {
		SingleLinkedListNode newRoot = null;
		
		while (root != null) {
			SingleLinkedListNode next = root.next;
			root.next = newRoot;
			newRoot = root;
			root = next;
		}
		return newRoot;
	}
}
