package yush.amazon;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string str of lowercase alphabets and an integer K, the task is to count all substrings of length K 
 * which have exactly K distinct characters.
 */
public class CountOfSubstrings {
	// sliding window

	public static int countSubstrings(String str, int K) {
		int N = str.length();

		int answer = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < K; i++) {
			if (map.get(str.charAt(i)) == null) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}
		}
		if (map.size() == K) {
			answer++;
		}

		for (int i = K; i < N; i++) {

			if (map.get(str.charAt(i)) == null) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}

			map.put(str.charAt(i - K), map.get(str.charAt(i - K)) - 1);

			if (map.get(str.charAt(i - K)) == 0) {
				map.remove(str.charAt(i - K));
			}

			if (map.size() == K) {
				answer++;
			}
		}
		return answer;
	}

	// Driver code
	public static void main(String[] args) {
		String str = "aabcdabbcdc";
		int K = 3;

		System.out.println(countSubstrings(str, K));
	}
}
