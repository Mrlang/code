package leetCode.monotonic_deque.monotonic_stack;

import java.util.Stack;

/**
 * Created by wangliang01 on 2020/7/4 using IDEA.
 */
public class stack_503_next_greater_number_2 {
    public int[] nextGreaterElements(int[] nums) {
        int nums2[] = new int[nums.length*2];
        for(int i=0; i<nums2.length; i++) {
            nums2[i] = nums[i%nums.length];
        }

        int[] res2 = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=nums2.length-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            res2[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        int res1[] = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            res1[i] = res2[i];
        }
        return res1;
    }

    public int[] nextGreaterElements_best(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        int length = nums.length;

        for(int i=length*2-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i%length]) {
                stack.pop();
            }

            res[i%length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i%length]);
        }
        return res;
    }
}
