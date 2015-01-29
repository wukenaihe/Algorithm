public class WordSearch {
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				if (exist(board, word, 0, i, j)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean exist(char[][] board, String word, int index, int x, int y) {
		if (index == word.length() - 1 && word.charAt(index) == board[x][y]) {
			return true;
		}

		if (word.charAt(index) != board[x][y]) {
			return false;
		}

		char temp = board[x][y];
		board[x][y] = '.';
		boolean b1 = false, b2 = false, b3 = false, b4 = false;
		if (x - 1 >= 0 && board[x - 1][y] != '.') {
			b1 = exist(board, word, index + 1, x - 1, y);
		}
		if (!b1 && y - 1 >= 0 && board[x][y - 1] != '.') {
			b2 = exist(board, word, index + 1, x, y - 1);
		}
		if (!b1 && !b2 && x + 1 < board.length && board[x + 1][y] != '.') {
			b3 = exist(board, word, index + 1, x + 1, y);
		}
		if (!b1 && !b2 && !b3 && y + 1 < board[0].length
				&& board[x][y + 1] != '.') {
			b4 = exist(board, word, index + 1, x, y + 1);
		}

		board[x][y] = temp;
		return b1 || b2 || b3 || b4;

	}

	public static void main(String[] args) {
		WordSearch w = new WordSearch();

		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' },
				{ 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		System.out.println(w.exist(board, "ABCCED"));
		System.out.println(w.exist(new char[][] { { 'A', 'B', 'C', 'E' },
				{ 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "SEE"));
		System.out.println(w.exist(new char[][] { { 'A', 'B', 'C', 'E' },
				{ 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCB"));
	}
}
