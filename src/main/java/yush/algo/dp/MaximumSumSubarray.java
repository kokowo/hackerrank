package yush.algo.dp;

/*
 * Find the contiguous subarray within an array (containing at least one number) that has the largest sum.
 * For example, given the array [2, 1, –3, 4, –1, 2, 1, –5, 4], The contiguous array [4, –1, 2, 1] has the largest sum = 6.
 */
public class MaximumSumSubarray {

	public int maxSubArray(int[] A) {
		int maxEndingHere = A[0], maxSoFar = A[0];
		for (int i = 1; i < A.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}

}
