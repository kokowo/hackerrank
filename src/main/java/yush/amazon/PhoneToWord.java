package yush.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PhoneToWord {
	static Character[][] numberToCharMap;

//	private static List<String> printWords(int[] numbers, int len, int numIndex, String s) {
//		if (len == numIndex) {
//			return new ArrayList<>(Collections.singleton(s));
//		}
//
//		List<String> stringList = new ArrayList<>();
//
//		for (int i = 0; i < numberToCharMap[numbers[numIndex]].length; i++) {
//			String sCopy = String.copyValueOf(s.toCharArray());
//			sCopy = sCopy.concat(numberToCharMap[numbers[numIndex]][i].toString());
//			stringList.addAll(printWords(numbers, len, numIndex + 1, sCopy));
//		}
//		return stringList;
//	}

	private static void printWords(int[] numbers) {
		generateNumberToCharMap();
		List<String> stringList = printWords2(numbers, numbers.length, 0, "");
//		stringList.stream().forEach(System.out::println);
	}

	private static void generateNumberToCharMap() {
		numberToCharMap = new Character[10][5];
		numberToCharMap[0] = new Character[] { '\0' };
		numberToCharMap[1] = new Character[] { '\0' };
		numberToCharMap[2] = new Character[] { 'a', 'b', 'c' };
		numberToCharMap[3] = new Character[] { 'd', 'e', 'f' };
		numberToCharMap[4] = new Character[] { 'g', 'h', 'i' };
		numberToCharMap[5] = new Character[] { 'j', 'k', 'l' };
		numberToCharMap[6] = new Character[] { 'm', 'n', 'o' };
		numberToCharMap[7] = new Character[] { 'p', 'q', 'r', 's' };
		numberToCharMap[8] = new Character[] { 't', 'u', 'v' };
		numberToCharMap[9] = new Character[] { 'w', 'x', 'y', 'z' };
	}

	// Driver code
	public static void main(String[] args) {
		int number[] = { 2, 3, 4 };
		printWords(number);
	}
	
	private static List<String> printWords2(int[] numbers, int len, int numIndex, String s) {
		if (len == numIndex) {
			System.out.println(numIndex + "-->" + s);
			return Arrays.asList(s);
		}

		List<String> stringList = new ArrayList<>();

		for (int i = 0; i < numberToCharMap[numbers[numIndex]].length; i++) {
			String sCopy = String.valueOf(s);
			sCopy = sCopy + numberToCharMap[numbers[numIndex]][i];
			stringList.addAll(printWords2(numbers, len, numIndex + 1, sCopy));
		}
		return stringList;
	}
	
	
	
}
