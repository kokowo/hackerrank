package yush.data.array;

/*
 * Equilibrium index of an array is an index such that the sum of elements at 
 * lower indexes is equal to the sum of elements at higher indexes
 */
public class EquilibriumIndex {
	int equilibrium(int arr[], int n) {
		int sum = 0; // initialize sum of whole array
		int leftsum = 0; // initialize leftsum

		/* Find sum of the whole array */
		for (int i = 0; i < n; ++i) {
			sum += arr[i];
		}

		for (int i = 0; i < n; ++i) {
			sum -= arr[i]; // sum is now right sum for index i

			if (leftsum == sum)
				return i;

			leftsum += arr[i];
		}

		/* If no equilibrium index found, then return 0 */
		return -1;
	}
}
