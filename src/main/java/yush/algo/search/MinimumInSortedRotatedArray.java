package yush.algo.search;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 */
public class MinimumInSortedRotatedArray {
	public int findMin(int[] A) {
		int L = 0, R = A.length - 1;
		while (L < R && A[L] >= A[R]) {
			int M = (L + R) / 2;
			if (A[M] > A[R]) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return A[L];
	}

}
