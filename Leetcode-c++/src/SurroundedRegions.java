public class SurroundedRegions {
	char[][] boards;
	int l1;
	int l2;

	public void solve(char[][] board) {
		boards = board;
		l1 = board.length;
		if (l1 == 0) {
			return;
		}
		l2 = board[0].length;

		for (int i = 1; i < l1 - 1; ++i) {
			for (int j = 1; j < l2 - 1; ++j) {
				if (boards[i][j]!='X'&&isSurround(i, j)) {
					change(i, j);
				}
			}
		}
	}

	private boolean isSurround(int x, int y) {
		if(x<0||x>=l1||y<0||y>=l2){
			return false;
		}
		if (boards[x][y] == 'X') {
			return true;
		}
		boards[x][y] = 'X';
		if (isSurround(x -1, y)&& isSurround(x, y - 1) && isSurround(x + 1, y)
				 && isSurround(x, y + 1)) {
			boards[x][y] = 'O';
			return true;
		} else {
			boards[x][y] = 'O';
			return false;
		}
	}

	private void change(int x, int y) {
		boards[x][y] = 'X';
		if (x-1>1&&boards[x - 1][y] == 'O') {
			change(x - 1, y);
		}

		if (x+1<l1-1&&boards[x + 1][y] == 'O') {
			change(x + 1, y);
		}
		if (y-1>1&&boards[x][y - 1] == 'O') {
			change(x, y - 1);
		}
		if (y+1<l2-1&&boards[x][y + 1] == 'O') {
			change(x, y + 1);
		}
	}

	public static void main(String[] args) {
//		char[][] board = new char[][] { { 'x', 'x', 'x', 'x' },
//				{ 'x', 'o', 'o', 'x' }, { 'x', 'x', 'o', 'x' },
//				{ 'x', 'o', 'x', 'x' } };
		char[][] board = new char[][] { { 'X', 'X', 'X' },
				{ 'X', 'O',  'X' }, { 'X', 'X', 'X' }};

//		char[][] board = new char[][] { { 'O', 'O', 'O' },
//				{ 'O', 'O',  'O' }, { 'O', 'O', 'O' }};
//		char[][] board = new char[][] { { 'O', 'O', 'O' },
//				{ 'O', 'O',  'O' }};
		
		SurroundedRegions s = new SurroundedRegions();
		s.solve(board);
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
