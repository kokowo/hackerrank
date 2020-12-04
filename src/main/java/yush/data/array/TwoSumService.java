package yush.data.array;

import java.util.HashMap;
import java.util.Map;

/*
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * add(input) – Add the number input to an internal data structure.
 * find(value) – Find if there exists any pair of numbers which sum is equal to the value.
 */
public class TwoSumService {
	private Map<Integer, Integer> table = new HashMap<>();

	public void add(int input) {
		int count = table.containsKey(input) ? table.get(input) : 0;
		table.put(input, count + 1);
	}

	public boolean find(int val) {
		for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
			int num = entry.getKey();
			int y = val - num;
			if (y == num) {
				// For duplicates, ensure there are at least two individual numbers.
				if (entry.getValue() >= 2)
					return true;
			} else if (table.containsKey(y)) {
				return true;
			}
		}
		return false;
	}
}
