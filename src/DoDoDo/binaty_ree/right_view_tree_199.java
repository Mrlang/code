package DoDoDo.binaty_ree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangliang01 on 2020/7/24 using IDEA.
 *
 *
 */
public class right_view_tree_199 {

    //================================================常规1============================================================================//
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> returnList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null) {
            queue.add(root);
        }

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                TreeNode curNode = queue.poll();
                if(curNode.right != null) {
                    queue.add(curNode.right);
                }

                if(curNode.left != null) {
                    queue.add(curNode.left);
                }

                if(i == 0) {
                    returnList.add(curNode.val);
                }
            }
        }

        return returnList;
    }

    //================================================常规2============================================================================//
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView_2(TreeNode root) {
        dfs(root, 0);
        return list;
    }

    public void dfs(TreeNode node, int depth) {
        if(node == null) {
            return;
        }

        if(list.size() == depth) {
            list.add(node.val);
        }

        dfs(node.right, depth+1);
        dfs(node.left, depth+1);
    }
}

class TreeNode{
     int val;
     TreeNode left;
     TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
