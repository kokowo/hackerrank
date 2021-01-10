package yush.data.array;

// Find path between two cell in matrix
class Path {

	static class Point {
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int x;
		public int y;
	}

	public static void isPath(int[][] matrix, Point start, Point end) {
		int col = matrix.length;
		int row = matrix[0].length;

		boolean visited[][] = new boolean[col][row];

		boolean flag = checkPath(matrix, start, end, visited);
		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static boolean isSafe(Point p, boolean[][] visited, int[][] matrix) {
		return (p.x >= 0 && p.x < matrix.length && p.y >= 0 && p.y < matrix[0].length && !visited[p.x][p.y]
				&& matrix[p.x][p.y] == 1);
	}

	public static boolean checkPath(int matrix[][], Point start, Point end, boolean visited[][]) {

		if (start.x == end.x && start.y == end.y) {
			return true;
		}

		visited[start.x][start.y] = true;
		int[] xmove = { 1, -1, 0, 0 };
		int[] ymove = { 0, 0, 1, -1 };

		for (int i = 0; i < 4; i++) {
			Point p = new Point(start.x + xmove[i], start.y + ymove[i]);
			if (isSafe(p, visited, matrix)) {
				if (checkPath(matrix, p, end, visited)) {
					return true;
				}
			}
		}

		return false;
	}
}
