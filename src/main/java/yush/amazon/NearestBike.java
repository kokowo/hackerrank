package yush.amazon;

public class NearestBike {

	public void find() {
		int xs = 0, ys = 0; // Start coordinates
		int maxDistance = 10;
		// Check point (xs, ys)

		for (int d = 1; d < maxDistance; d++) {
			for (int i = 0; i < d + 1; i++) {
				int x1 = xs - d + i;
				int y1 = ys - i;

				// Check point (x1, y1)

				int x2 = xs + d - i;
				int y2 = ys + i;

				// Check point (x2, y2)
			}

			for (int i = 1; i < d; i++) {
				int x1 = xs - i;
				int y1 = ys + d - i;

				// Check point (x1, y1)

				int x2 = xs + i;
				int y2 = ys - d + i;

				// Check point (x2, y2)
			}
		}
	}
}
