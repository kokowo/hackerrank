package yush.data.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	/*
	 * Given an array of integers, find two numbers such that they add up to a
	 * specific target number.
	 */
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			int x = numbers[i];
			if (map.containsKey(target - x)) {
				return new int[] { map.get(target - x) + 1, i + 1 };
			}
			map.put(x, i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	/*
	 * Similar to Question [1. Two Sum], except that the input array is already
	 * sorted in ascending order.
	 */

	public int[] twoSum2(int[] numbers, int target) { // Assume input is already sorted.
		int i = 0, j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum < target) {
				i++;
			} else if (sum > target) {
				j--;
			} else {
				return new int[] { i + 1, j + 1 };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
