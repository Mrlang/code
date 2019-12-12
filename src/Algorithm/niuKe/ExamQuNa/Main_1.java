package Algorithm.niuKe.ExamQuNa;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by Mr_liang on 2017/4/1 using IDEA.
 */
public class Main_1 {
    public static void main(String args[]) {


        Scanner sc = new Scanner(System.in);
        int n = new Integer(sc.nextLine());
        String[] arr1 = sc.nextLine().split(" ");
        int[] pre = change(arr1);

        arr1 = sc.nextLine().split(" ");
        int[] mid = change(arr1);

        TreeNode root = funA(pre, mid, pre.length);
        printTree(root);

    }

    public static void printTree(TreeNode node){
        ArrayDeque<TreeNode> que = new ArrayDeque<>();
        int removeNum = 1;
        que.add(node);
        while(!que.isEmpty()){
            if(removeNum>0){
                int temp=0;
                for(int i=0; i<removeNum; i++) {
                    TreeNode n = que.removeFirst();
                    System.out.print(n.value + " ");
                    if(n.left!=null) {
                        que.add(n.left);
                        temp++;
                    }
                    if(n.right!=null){
                        que.add(n.right);
                        temp++;
                    }
                }
                removeNum = temp;
            }

        }
    }

    public static int[] change(String[] arr){
        int[] nums = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            nums[i] = new Integer(arr[i]);
        }
        arr = null;
        return nums;
    }


    public static TreeNode funA(int[] preOrder ,int[] inOrder,int len){
        if(len<=0||preOrder==null||inOrder==null){
            return null;
        }
        else return funB(preOrder,inOrder,len,0,0);
    }
    public static TreeNode funB(int[] a,int[] b,int len,int lowa,int lowb){
        int rootValue = a[lowa];
        TreeNode node = new TreeNode(rootValue,null,null);
        if(len==1){
            if(a[lowa]==b[lowb]){
                return node;
            } else
                try {
                    throw new Exception("invalid input");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        int i = lowb;
        while(i<lowb+len&&b[i]!=rootValue)
            i++;
        if(i==len+lowb&&b[i]!=rootValue)
            try {
                throw new Exception("error");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        int leftlength = i-lowb;
        int rightlength = len-i+lowb-1;
        int aLeftStart = lowa+1;
        int aRightStart = leftlength+lowa+1;
        int bLeftStart = lowb;
        int bRightStart = i+1;
        if(leftlength>0){
            node.left = funB(a,b,leftlength,aLeftStart,bLeftStart);
        }
        if(rightlength>0){
            node.right = funB(a,b,rightlength,aRightStart,bRightStart);
        }
        return node;
    }
}

class TreeNode{
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void print(){
        System.out.println(this.value);
    }

}
