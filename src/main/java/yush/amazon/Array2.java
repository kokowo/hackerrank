package yush.amazon;

public class Array2 {
	public static void main(String[] argv) {
		int[] data = { 4, 5, 1, 3, 7, 6 };

		int mark = 5;

		int lessthan = 0;

		for (int i = 0; i < data.length; i++) {
			if (data[i] >= mark) {
				if (lessthan <= i) {
					lessthan = i + 1;
				}
				while (lessthan < data.length && data[lessthan] >= mark) {
					lessthan++;
				}
				if (lessthan >= data.length) {
					break;
				}
				int tmp = data[i];
				data[i] = data[lessthan];
				data[lessthan] = tmp;
			}
		}
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

}
