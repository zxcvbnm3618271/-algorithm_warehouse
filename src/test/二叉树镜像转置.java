package test;

import test.*;

public class ����������ת�� {
		//ת�ú���
public void Mirror(TreeNode root) {
        TreeNode temp;
        if (root!=null) {
			temp=root.left;
			root.left=root.right;
			root.right=temp;
			if (root.left!=null) {
				Mirror(root.left);
			}
			if (root.right!=null) {
				Mirror(root.right);
			}
		}
    }
}
