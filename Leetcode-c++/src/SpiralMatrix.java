import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		int i = 0;
		List<Integer> list = new ArrayList<Integer>();
		int rowL = matrix.length - 1;
		if(rowL<0){
			return list;
		}
		int colL = matrix[0].length - 1;
		
		while ((rowL - 2 * i) >= 1 && (colL - 2 * i) >= 1) {
			for (int j = i; j < colL - i; ++j) {
				list.add(matrix[i][j]);
			}

			for (int j = i; j < rowL - i; ++j) {
				list.add(matrix[j][colL - i]);
			}

			for (int j = colL - i; j > i; --j) {
				list.add(matrix[rowL - i][j]);
			}

			for (int j = rowL - i; j > i; --j) {
				list.add(matrix[j][i]);
			}
			i++;
		}
		if ((rowL - 2 * i) == 0 && (colL - 2 * i) == 0) {
			list.add(matrix[rowL - i][colL - i]);
		} else if ((rowL - 2 * i) == 0) {
			for (int j = i; j <= colL - i; ++j) {
				list.add(matrix[i][j]);
			}
		} else if ((colL - 2 * i) == 0) {
			for (int j = i; j <= rowL - i; ++j) {
				list.add(matrix[j][i]);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 10, 11, 12 } };
		SpiralMatrix s = new SpiralMatrix();
		System.out.println(s.spiralOrder(matrix));
		int[][] matrix1 = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 } };
		System.out.println(s.spiralOrder(matrix1));
		System.out.println(s.spiralOrder(new int[][]{{1,2},{3,4}}));

	}
}
