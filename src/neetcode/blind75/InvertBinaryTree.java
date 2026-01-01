package neetcode.blind75;

import neetcode.blind75.HelperClasses.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return root;
    }
}
