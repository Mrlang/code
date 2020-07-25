package DoDoDo.sword_point;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.Stack;

/**
 * Created by Mr_liang on 2017/3/24 using IDEA.
 */

//http://blog.csdn.net/sgbfblog/article/details/7773103
//TODO: 非递归遍历二叉树,先序 中序 后序都有；注意是二叉树，子节点分left,right;
// todo:多叉树的子节点是List<TreeNode> root.children ;
class BinTreeNode<T> {
    T data;
    BinTreeNode left;
    BinTreeNode right;

    public BinTreeNode(T data, BinTreeNode left, BinTreeNode right) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

    @Override
    public String toString() {
        Integer l=null,r=null;
        if(left!=null)
            l = (int)left.data;
        if(right!=null)
            r = (int)right.data;
        return "ForeachBinTreeTool{" + "data=" + data +
                ", left=" + l +
                ", right=" + r +
                "}";
    }

    /**
     * 随机生成一个二叉树。
     * @param treeHight 指定要生成树的高度
     * @param dataRange 指定节点数据的范围
     * @return
     */
    public static BinTreeNode generateNewTree(int treeHight, int dataRange){
        return generateNewTree(treeHight, dataRange, new Random(System.currentTimeMillis()));
    }

    //随机生成一个二叉树
    public static BinTreeNode generateNewTree(int treeHight, int dataRange, Random randomData){
        if(treeHight==0)
            return null;

        BinTreeNode head = new BinTreeNode(randomData.nextInt(dataRange), null, null);
        int leftOrRight = (int)(Math.random()*100) & 1;
        /*
        * treeHeight==1 ? 0 : randomData.nextInt(treeHeight-1);
        * Random.nextInt()要求参数必须是正数,当treeHeight=1时, head的生成已经满足的一个层数为1的子树,
        * 可以直接把head的left,right赋值为null(通过head.left = getBinTreeAndDataIsInt(0,range))
        */
        int leftHeight = leftOrRight==1 ? treeHight-1 : treeHight==1?0:randomData.nextInt(treeHight-1);
        int rightHeight = leftOrRight==1 ? treeHight==1?0:randomData.nextInt(treeHight-1) : treeHight-1;
        if(leftHeight>0)    head.left = generateNewTree(leftHeight, dataRange, randomData);
        if(rightHeight>0)   head.right = generateNewTree(rightHeight, dataRange, randomData);

        return head;
    }

    // 对一个节点进行遍历,根据 order+"Order_"+solution选择遍历方式
    public static void order(BinTreeNode node, String order, int solution) {
        Method m = null;
        try {
            m =BinTreeNode.class.getDeclaredMethod(order+"Order_"+solution, BinTreeNode.class);
            m.invoke(null,node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TODO:最简单的非递归先序遍历,只需传进来树的根节点
    private static void preOrder_1(BinTreeNode node){
        Stack<BinTreeNode> stack = new Stack<BinTreeNode>();
        if(node != null)
            stack.push(node);
        while(!stack.isEmpty()) {
            BinTreeNode current = stack.pop();
            System.out.println(current);
            if(current.right!=null)
                stack.push(current.right);
            if(current.left!=null)
                stack.push(current.left);
        }
    }

    // TODO:稍复杂的非递归先序遍历，只需传进来树的根节点
    private static void preOrder_2(BinTreeNode node){
        Stack<BinTreeNode> stack = new Stack<BinTreeNode>();
        BinTreeNode root = node;
        while(root!=null || !stack.isEmpty()) {
            if(root!=null){
                stack.push(root);
                System.out.println(root);
                if(root.left != null)
                    root = root.left;
            }else {
                root = stack.pop();
                root = root.right;
            }
        }

    }

    // TODO:递归先序遍历，只需传进来树的根节点
    private static void preOrder_3(BinTreeNode node){
        if(node==null)
            return;
        System.out.println(node);
        if(node.left!=null)
            preOrder_3(node.left);
        if(node.right!=null)
            preOrder_3(node.right);
    }

    // TODO:非递归的中序遍历，只需传进来树的根节点
    public static void midOrder_1(BinTreeNode node){
        Stack<BinTreeNode> stack = new Stack<>();
        while(node!=null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                System.out.println(node);
                node = node.right;
            }
        }
    }

    // TODO:递归的中序遍历，只需传进来树的根节点
    public static void midOrder_2(BinTreeNode node){
        if(node==null)
            return;
        midOrder_2(node.left);
        System.out.println(node);
        midOrder_2(node.right);
    }

    // TODO:非递归的后序遍历，只需传进来树的根节点
    public static void lastOrder_1(BinTreeNode node){
        Stack<BinTreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
        if(node !=null)
            stack1.push(node);
        else
            return ;
        while(stack1!=null) {
            BinTreeNode temp = stack1.pop();
            stack2.push(temp);
            if(temp.left != null)
                stack1.push(temp.left);
            if(temp.right != null)
                stack2.push(temp.right);
        }

        while(!stack2.isEmpty()) {
            BinTreeNode temp = stack2.pop();
            System.out.println(temp);
        }
    }

    // TODO:递归的后序遍历，只需传进来树的根节点
    public static void lastOrder_2(BinTreeNode node){
        if(node == null)
            return;
        lastOrder_2(node.left);
        lastOrder_2(node.right);
        System.out.println(node);
    }

    public static void lastOrder_3(BinTreeNode node){

    }
}
