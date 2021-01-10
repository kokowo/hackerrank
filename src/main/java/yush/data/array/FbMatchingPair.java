package yush.data.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t 
 * after swapping exactly two characters within s.
 */
public class FbMatchingPair {
	int matchingPairs(String s, String t) {
		// Write your code here
		Set<String> mismatchS = new HashSet<>();
		char[] sToChar = s.toCharArray();
		char[] tToChar = t.toCharArray();
		int matching = 0;
		for (int i = 0; i < sToChar.length; i++) {
			if (sToChar[i] != tToChar[i]) {
				mismatchS.add(sToChar[i] + "" + tToChar[i]);
			} else
				matching++;
		}
		for (String mism : mismatchS) {
			String reverse = mism.charAt(1) + "" + mism.charAt(0);
			if (mismatchS.contains(reverse)) {
				return matching + 2;
			}
		}
		if (mismatchS.size() <= 1)
			matching--;
		if (mismatchS.size() == 0)
			matching--;
		return matching;
	}
}
