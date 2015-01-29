
public class ConstructTreePreordeInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
    private TreeNode buildTree(int[] preorder,int leftA,int rightA,int[] inorder,int leftB,int rightB){
        if(leftA>rightA){
            return null;
        }else if(leftA==rightA){
            return new TreeNode(preorder[leftA]);
        }else{
            int rootVal=preorder[leftA];
            int i=leftB;
            for(;i<=rightB;++i){
                if(inorder[i]==rootVal){
                    break;
                }
            }
            TreeNode root=new TreeNode(rootVal);
            root.left=buildTree(preorder,leftA+1,leftA+i-leftB,inorder,leftB,i-1);
            root.right=buildTree(preorder,leftA+i-leftB+1,rightA,inorder,i+1,rightB);
            return root;
        }
    }
    
    public static void main(String[] args) {
		ConstructTreePreordeInorder p=new ConstructTreePreordeInorder();
		TreeNode t=p.buildTree(new int[]{1,2,3},new int[]{2,1,3});
		System.out.println(t);
	}

}
