import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
	public List<TreeNode> generateTrees(int n) {
		if(n<1){
			List<TreeNode> resList=new ArrayList<TreeNode>();
			resList.add(null);
			return resList;
		}
		List<TreeNode> result=generateTrees(1, n);
		return result;
	}
	
	
	public List<TreeNode> generateTrees(int start,int end){
		List<TreeNode> list=new ArrayList<TreeNode>();
		if(start>end){
			return list;
		}
		if(start==end){
			list.add(new TreeNode(start));
			return list;
		}
		for(int i=start;i<=end;++i){
			List<TreeNode> lefts=generateTrees(start,i-1);
			List<TreeNode> rights=generateTrees(i+1, end);
			
			for(int k=0;k<lefts.size();++k){
				TreeNode left=lefts.get(k);
				for(int f=0;f<rights.size();++f){
					TreeNode right=rights.get(f);
					
					TreeNode root=new TreeNode(i);
					root.left=left;
					root.right=right;
					list.add(root);
				}
			}
			if(lefts.size()==0){
				for(int k=0;k<rights.size();++k){
					TreeNode t=new TreeNode(i);
					t.right=rights.get(k);
					list.add(t);
				}
			}
			
			if(rights.size()==0){
				for(int k=0;k<lefts.size();++k){
					TreeNode t=new TreeNode(i);
					t.left=lefts.get(k);
					list.add(t);
				}
			}
		}
		return list;
	}
	
	
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees2 u=new UniqueBinarySearchTrees2();
		
		List<TreeNode> list=u.generateTrees(3);
		
		System.out.println(list);
	}
	
}
