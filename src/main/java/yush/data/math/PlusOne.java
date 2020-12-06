package yush.data.math;

import java.util.List;

/*
 * Given a number represented as an array of digits, plus one to the number.
 */
public class PlusOne {
	public void plusOne(List<Integer> digits) {
		for (int i = digits.size() - 1; i >= 0; i--) {
			int digit = digits.get(i);
			if (digit < 9) {
				digits.set(i, digit + 1);
				return;
			} else {
				digits.set(i, 0);
			}
		}
		digits.add(0);
		digits.set(0, 1);
	}
}
