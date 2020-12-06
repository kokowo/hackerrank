package yush.data.math;

/*
 * Reverse digits of an integer. For example: x = 123, return 321.
 */
public class ReverseInt {
	public int reverse(int x) {
		int ret = 0;
		while (x != 0) {
			ret = ret * 10 + x % 10;
			x /= 10;
		}
		return ret;
	}
}
