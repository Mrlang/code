package offer;

import java.util.Arrays;

/**
 * 重建二叉树
 * @author wangliang01 on 2019/3/8 using IDEA.
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 解决思路:递归,题上给的方法接收参数有限，可以自己定义一个方法被main方法类调用接口
 */
public class five {
    public static void main(String args[]){

    }
}
class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
       return reCall(pre, in, 0, pre.length-1, 0, in.length-1);
    }

    TreeNode reCall(int [] pre,int [] in, int pre_begin, int pre_end, int in_being, int in_end){
        if(pre_begin > pre_end || in_being > in_end){
            return  null;
        }

        int rootValue = pre[pre_begin];
        TreeNode root = new TreeNode(rootValue);
        for(int index=in_being; index<in_end; index++) {
            if(rootValue == pre[pre_end]){
                root.left = reCall(pre, in, pre_begin+1, pre_begin + index - in_being, in_being, index-1);
                root.right = reCall(pre, in, pre_begin + index - in_being, pre_end, index + 1, in_end);
                break;
            }
        }

        return root;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}