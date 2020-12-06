package yush.data.stack;

import java.util.Stack;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time
 */
public class MinStack {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	public void pop() {
		if (stack.pop().equals(minStack.peek()))
			minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
