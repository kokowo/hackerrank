package yush.data.stack;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class ValidParentheses {
	private static final Map<Character, Character> map = new HashMap<Character, Character>() {
		private static final long serialVersionUID = 1L;

		{
			put('(', ')');
			put('{', '}');
			put('[', ']');
		}
	};

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				stack.push(c);
			} else if (stack.isEmpty() || map.get(stack.pop()) != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	Queue<Integer> minHeap = new PriorityQueue<>();
	Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
}
