package leetCode.DFS_backTrack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by wangliang01 on 2020/7/4 using IDEA.
 */
public class BFS_111_min_depth_of_binary_tree {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        int depth = 1;
        while(!queue.isEmpty()) {
            int curSize = queue.size();
            for(int i=0; i<curSize; i++) {
                TreeNode curNode = queue.poll();
                if(curNode.left == null && curNode.right == null) {
                    return depth;
                }
                if(curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if(curNode.right != null) {
                    queue.addLast(curNode.right);
                }
            }

            depth++;
        }
        return depth;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
