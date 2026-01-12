package neetcode.blind75;

import neetcode.blind75.HelperClasses.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameBinaryTree {
    public static void main(String[] args) {
//        TreeNode left = new TreeNode(2,null, null);
//        TreeNode right = new TreeNode(3,null, null);
//        TreeNode p = new TreeNode(1,left,right);
//        TreeNode q = new TreeNode(1,left,right);

        TreeNode p = new TreeNode(4);
        p.left = new TreeNode(7);
        TreeNode q = new TreeNode(4);
        q.left = null; // explicit for clarity
        q.right = new TreeNode(7);

        SameBinaryTree sameBinaryTree = new SameBinaryTree();
        boolean result = sameBinaryTree.isSameTree(p,q);
        System.out.println("Is same binary tree: " +result);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();

        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;

        queueP.add(p);
        queueQ.add(q);

        TreeNode nodeP;
        TreeNode nodeQ;

        while(!queueP.isEmpty() && !queueQ.isEmpty()){

            nodeP = queueP.poll();
            nodeQ = queueQ.poll();

            if(nodeP==null && nodeQ==null)
                continue;
            if((nodeP==null && nodeQ!=null) || (nodeP != null && nodeQ==null))
                return false;

            queueP.add(nodeP.left);
            queueP.add(nodeP.right);

            queueQ.add(nodeQ.left);
            queueQ.add(nodeQ.right);

            // System.out.println("node P: "+ nodeP.val +" "+ nodeQ.val+ "node Q:"+nodeQ.val);
            if (nodeP.val!=nodeQ.val)
                return false;

        }
        return true;
    }
}
