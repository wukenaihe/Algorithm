
public class WordSearch {
	char[] chars;
	char[][] board;
	int l1,l2;
	public boolean exist(char[][] board, String word) {
		this.board=board;
		chars=word.toCharArray();
		l1=board.length;
		l2=board[0].length;
		
		if(chars.length>l1*l2){
			return false;
		}
		
		for(int i=0;i<l1;++i){
			for(int j=0;j<l2;++j){
				if(exits(i, j, 0)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean exits(int x,int y,int num){
		if(board[x][y]!=chars[num]){
			return false;
		}else if(num==chars.length-1){
			return true;
		}else{
			char c=board[x][y];
			board[x][y]='#';
			if(x-1>0&&exits(x-1, y, num+1)){
				return true;
			}
			
			if(x+1<l1&&exits(x+1,y,num+1)){
				return true;
			}
			
			if(y-1>0&&exits(x, y-1, num+1)){
				return true;
			}
			
			if(y+1<l2&&exits(x,y+1, num+1)){
				return true;
			}
			board[x][y]=c;
		}
		
		return false;
	}

	
	public static void main(String[] args) {
		WordSearch w=new WordSearch();
		
		char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		
		System.out.println(w.exist(board, "ABCCED"));
		System.out.println(w.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
		System.out.println(w.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCB"));
	}
}
