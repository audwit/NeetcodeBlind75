package neetcode.blind75;

import neetcode.blind75.HelperClasses.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfABinaryTree {
    public static void main(String[] args) {
        // Create all non-null nodes
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20, node15, node7); // node20 has 15 as left, 7 as right

// Root links to 9 (left) and 20 (right)
        TreeNode root = new TreeNode(3, node9, node20);

        int result=0;

        MaxDepthOfABinaryTree maxDepthOfABinaryTree = new MaxDepthOfABinaryTree();
        result = maxDepthOfABinaryTree.maxDepth(root);
        System.out.println("The depth of the input tree is: " +result);
    }

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth=0;


        while(true){
            int nodesOnALevel = queue.size();
            if(nodesOnALevel==0)
                return depth;

            while(nodesOnALevel>0){
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                nodesOnALevel--;
            }
            depth++;
        }
    }
}