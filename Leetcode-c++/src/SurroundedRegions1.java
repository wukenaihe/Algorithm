import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions1 {
	class Pair {  
        int i;  
        int j;  
  
        Pair(int i, int j) {  
            this.i = i;  
            this.j = j;  
        }  
    }  
  
    private int M;  
    private int N;  
  
    public void solve(char[][] board) {  
        if (board == null || board.length <= 0) {  
            return;  
        }  
  
        this.M = board.length;  
        this.N = board[0].length;  
        Queue<Pair> queue = new LinkedList<Pair>();  
        for (int i = 0; i < M; ++i) {  
            if (board[i][0] == 'O') {  
                queue.add(new Pair(i, 0));  
                bfs(queue, board);  
            }  
            if (board[i][N - 1] == 'O') {  
                queue.add(new Pair(i, N - 1));  
                bfs(queue, board);  
            }  
        }  
        for (int j = 1; j < N - 1; ++j) {  
            if (board[0][j] == 'O') {  
                queue.add(new Pair(0, j));  
                bfs(queue, board);  
            }  
            if (board[M - 1][j] == 'O') {  
                queue.add(new Pair(M - 1, j));  
                bfs(queue, board);  
            }  
        }  
        for (int i = 0; i < M; ++i) {  
            for (int j = 0; j < N; ++j) {  
                if (board[i][j] == 'O') {  
                    board[i][j] = 'X';  
                } else if (board[i][j] == '#') {  
                    board[i][j] = 'O';  
                }  
            }  
        }  
    }  
  
    private void bfs(Queue<Pair> queue, char[][] board) {  
        while (!queue.isEmpty()) {  
            Pair pair = queue.poll();  
            int i = pair.i;  
            int j = pair.j;  
            if (i < 0 || i >= M || j < 0 || j >= N || board[i][j] != 'O') {  
                continue;  
            }  
            board[i][j] = '#';  
            queue.add(new Pair(i - 1, j));  
            queue.add(new Pair(i + 1, j));  
            queue.add(new Pair(i, j - 1));  
            queue.add(new Pair(i, j + 1));  
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
		
		SurroundedRegions1 s = new SurroundedRegions1();
		s.solve(board);
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
