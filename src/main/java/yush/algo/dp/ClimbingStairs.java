package yush.algo.dp;

/*
 * You are climbing a staircase. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to
 * the top?
 */
public class ClimbingStairs {

	public int climbStairs(int n) {
		int p = 1, q = 1;
		for (int i = 2; i <= n; i++) {
			int temp = q;
			q += p;
			p = temp;
		}
		return q;
	}
}
