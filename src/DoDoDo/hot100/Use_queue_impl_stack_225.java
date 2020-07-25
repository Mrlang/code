package DoDoDo.hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangliang01 on 2020/7/11 using IDEA.
 */
public class Use_queue_impl_stack_225 {
    private Queue<Integer> queue;
    private int top;

    /** Initialize your data structure here. */
    public Use_queue_impl_stack_225() {
        queue = new LinkedList<>();
    }


    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    // TODO push()复杂度O(1), pop复杂度O(n)
    public void push(int x) {
        top = x;
        queue.add(x);
    }

    // TODO push()复杂度O(1), pop复杂度O(n)
    public int pop() {
        int curSize = queue.size();
        while(curSize > 1) {
            top = queue.remove();
            queue.add(top);
            curSize--;
        }

        return queue.remove();
    }

    // TODO push()复杂度O(1), pop复杂度O(n)
    public int top() {
        return top;
    }

//=====================================================================================================/

    // TODO push()复杂度O(n), pop复杂度O(1)
    public void push_2(int x) {
        int lastSize = queue.size();
        queue.add(x);
        while(lastSize > 0) {
            queue.add(queue.remove());
            lastSize--;
        }
    }

    // TODO push()复杂度O(n), pop复杂度O(1)
    public int pop_2() {
        return queue.remove();
    }

    // TODO push()复杂度O(n), pop复杂度O(1)
    public int top_2() {
        return queue.peek();
    }

}