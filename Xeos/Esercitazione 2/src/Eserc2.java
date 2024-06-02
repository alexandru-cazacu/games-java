
public class Eserc2 {
	public static int[][] somma (int[][] m1, int[][] m2) {
		int rows = m1.length;
		int cols = m1[0].length;
		int[][] result = new int[rows][cols];
		
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				result[y][x] = m1[y][x] + m2[y][x];
			}
		}
		
		return result;
	}
}
