import java.util.ArrayList;
import java.util.List;


public class BinaryTreeInorderTraversal {

	List<Integer> list=new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        
        return list;
    }
}
