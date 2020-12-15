package yush.data.array;

public class PushZeroInArray {
	public static void main(String[] argv) {

		int[] data = { 1, 0, 3, 2, 5, 0, 3, 0 };

		int count = 0;
		int nextNonZero = -1;
		while (count < data.length) {

			if (data[count] == 0) {
				if (nextNonZero < 0) {
					nextNonZero = count + 1;
				}
				while (nextNonZero < data.length && data[nextNonZero] == 0) {
					nextNonZero++;
				}
				if (nextNonZero >= data.length) {
					break;
				}
				data[count] = data[nextNonZero];
				data[nextNonZero] = 0;
			}
			count++;
		}

		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

	//
	void pushZerosToEnd(int arr[], int n) {
		int count = 0; // Count of non-zero elements

		// Traverse the array. If element encountered is
		// non-zero, then replace the element at index 'count'
		// with this element
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				arr[count++] = arr[i]; // here count is incremented
			}
		}
		// Now all non-zero elements have been shifted to
		// front and 'count' is set as index of first 0.
		// Make all elements 0 from count to end.
		while (count < n)
			arr[count++] = 0;
	}

}
