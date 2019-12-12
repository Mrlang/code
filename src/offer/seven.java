package offer;

import java.util.Stack;

/**
 * 用两个栈实现队列  https://www.nowcoder.com/questionTerminal/54275ddae22f475981afa2244dd448c6
 * 剑指offer第7题
 * @author wangliang01 on 2019/3/8 using IDEA.
 */
public class seven {

    public static void main(String args[]){

    }

    class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if(stack1.empty()&&stack2.empty()){
                throw new RuntimeException("Queue is empty!");
            }
            if(stack2.empty()){
                while(!stack1.empty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
