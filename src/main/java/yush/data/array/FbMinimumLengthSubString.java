package yush.data.array;

public class FbMinimumLengthSubString {

	public static void main(String[] argv) {
		System.out.println(minLengthSubstring("ADOBECODEBANC", "ABC"));
	}

	public static String minLengthSubstring(String s, String t) {
		System.out.println(s);
		System.out.println(t);

		int[] map = new int[128];
		char[] chs = s.toCharArray();
		for (char c : t.toCharArray()) {
			map[c]++;
		}

		int count = t.length(), slow = 0, fast = 0, head = 0, len = Integer.MAX_VALUE;

		while (fast < chs.length) {
			if (map[chs[fast++]]-- > 0) {
				count--;
			}
			System.out.println("FAST: " + chs[fast - 1] + "|" + count);
			while (count == 0) {
				System.out.println("\tSLOW: " + chs[slow] + "|" + count);
				if (fast - slow < len) {
					len = fast - slow;
					head = slow;
				}
				if (map[chs[slow++]]++ == 0) {
					count++;
				}
			}
		}
		System.out.println("LEN: " + len);

		return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);

	}
}
