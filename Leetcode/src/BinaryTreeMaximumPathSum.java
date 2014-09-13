
public class BinaryTreeMaximumPathSum {
	public int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        deep(root);
        return max;
    }
    
    public int deep(TreeNode root){
        if(root==null){
            return 0;
        }
        int d1=deep(root.left);
        int d2=deep(root.right);
        d1=d1<0?0:d1;
        d2=d2<0?0:d2;
        max=Math.max(d1+d2+root.val,max);
        return Math.max(d1,d2)+root.val;
    }
}
