package test;
/*
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class 二叉树的深度 {
//递归写法
	public int TreeDepth(TreeNode root) {
        if(root==null){
    return 0;
}
   
int nLelt=TreeDepth(root.left);
int nRight=TreeDepth(root.right);
 
return nLelt>nRight?(nLelt+1):(nRight+1);
}
}
