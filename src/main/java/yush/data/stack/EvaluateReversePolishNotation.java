package yush.data.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {

	interface Operator {
		int eval(int x, int y);
	}

	private static final Map<String, Operator> OPERATORS = new HashMap<String, Operator>() {
		private static final long serialVersionUID = 1L;

		{
			put("+", new Operator() {
				public int eval(int x, int y) {
					return x + y;
				}
			});
			put("-", new Operator() {
				public int eval(int x, int y) {
					return x - y;
				}
			});
			put("*", new Operator() {
				public int eval(int x, int y) {
					return x * y;
				}
			});
			put("/", new Operator() {
				public int eval(int x, int y) {
					return x / y;
				}
			});
		}
	};

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (OPERATORS.containsKey(token)) {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(OPERATORS.get(token).eval(x, y));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

}
