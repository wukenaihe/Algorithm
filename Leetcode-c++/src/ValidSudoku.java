public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if(board==null){
			return false;
		}
		int rLength=board.length;
		if(rLength!=9){
			return false;
		}
		int cLength=board[0].length;
		if(cLength!=9){
			return false;
		}
		for(int i=0;i<9;++i){
			boolean[] tags=new boolean[9];
			for(int j=0;j<9;++j){
				if(board[i][j]=='.'){
					continue;
				}else {
					int num=board[i][j]-'0';
					if(tags[num]){
						return false;
					}else{
						tags[num]=true;
					}
				}
			}
		}
		
		for(int i=0;i<9;++i){
			boolean[] tags=new boolean[9];
			for(int j=0;j<9;++j){
				if(board[j][i]=='.'){
					continue;
				}else {
					int num=board[j][i]-'0';
					if(tags[num]){
						return false;
					}else{
						tags[num]=true;
					}
				}
			}
		}
		
		for(int i=0;i<9;i=i+3){
			for(int j=0;j<9;j=j+3){
				boolean[] tags=new boolean[9];
				for(int k=i;k<i+3;++k){
					for(int f=j;f<j+3;++f){
						if(board[k][f]=='.'){
							continue;
						}else{
							int num=board[k][f]-'0';
							if(tags[num]){
								return false;
							}else{
								tags[num]=true;
							}
						}
					}
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
	}
}
