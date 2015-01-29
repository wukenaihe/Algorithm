import java.util.ArrayList;
import java.util.Arrays;

public class SolveNQueens1 {
	String[] strs;
	int n;
	
	public ArrayList<String[]> solveNQueens(int n) {
		this.n=n;
		strs=new String[n];
		StringBuilder template;
		ArrayList<String[]> list;
		for(int i=0;i<n;++i){
			template=new StringBuilder();
			for(int j=0;j<n;++j){
				if(i==j){
					template.append('Q');
				}else{
					template.append('.');
				}
			}
			String str=template.toString();
			strs[i]=str;
		}
		list=handle(0, new boolean[n][n]);
		
		return list;
	}
	
	public ArrayList<String[]> handle(int layer,boolean[][] used){
		ArrayList<String[]> list=new ArrayList<String[]>();
		for(int i=0;i<n;++i){
			if(!used(layer, i, used)){
				if(layer==n-1){
					String[] ss=new String[n];
					ss[layer]=strs[i];
					list.add(ss);
				}else{
					boolean[][] usedCopy=copy(used);
					usedCopy[layer][i]=true;
					ArrayList<String[]> subList=handle(layer+1, usedCopy);
					for (String[] strings : subList) {
						strings[layer]=strs[i];
					}
					list.addAll(subList);
				}
			}
		}
		return list;
	}
	
	private boolean[][] copy(boolean[][] used){
		boolean[][] result=new boolean[n][n];
		for(int i=0;i<n;++i){
			System.arraycopy(used[i], 0, result[i], 0, n);
		}
		return result;
	}
	
	
	private boolean used(int x,int y,boolean[][] used){
		boolean xP = false;
		boolean yP=false;
		boolean x1=false;
		boolean x2=false;
		for(int i=0;i<n;++i){
			xP|=used[i][y];
			if(xP){
				return true;
			}
		}
		
		for(int i=0;i<n;++i){
			yP|=used[x][i];
			if(yP){
				return true;
			}
		}
		
		
		int min=Math.min(x, n-1-y);
		int i=x-min,j=y+min;
		while(i<n&&j>=0){
			x1|=used[i][j];
			if(x1){
				return true;
			}
			i++;
			j--;
		}
		
		min=Math.min(x, y);
		i=x-min;
		j=y-min;
		while(i<n&&j<n){
			x2|=used[i][j];
			if(x2){
				return true;
			}
			i++;
			j++;
		}
		return false;
		
	}
	
	private void print(ArrayList<String[]> list){
		for (String[] strings : list) {
			System.out.println();
			for(int i=0;i<n;++i){
				System.out.println(strings[i]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		SolveNQueens1 s=new SolveNQueens1();
		s.print(s.solveNQueens(4));
		
	}
}
