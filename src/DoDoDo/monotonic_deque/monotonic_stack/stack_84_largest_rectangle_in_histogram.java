package DoDoDo.monotonic_deque.monotonic_stack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class stack_84_largest_rectangle_in_histogram {
    // 暴力法求解1:遍历所有可能的矩形左右边界，比较面积
    public int largestRectangleArea(int[] heights) {

        /**
         * TODO
         * 刚开始的错误定义: int max_area = Integer.MIN_VALUE;
         * 这里最小面积值应该为0
         * 最坏情况下就是输入为[],可勾勒出的矩形面积为0,此时如果Integer.MIN_VALUE返回则报错
         *
         */
        int max_area = 0;
        int length = heights.length;
        for (int i=0; i<length; i++) {
            int min_height = heights[i];
            for(int j=i; j<length; j++) {
                min_height = Math.min(min_height, heights[j]);
                int cur_area = min_height * (j - i + 1);
                max_area = Math.max(cur_area, max_area);
            }
        }

        return max_area;
    }

    //暴力法求解2：以每个高度作为所在矩形的最小高度(也就是把自己作为短板),比较所在矩形的面积
    public int largestRectangleArea_2(int[] heights) {
        int max_area = 0;
        int length = heights.length;
        for(int i=0; i<length; i++) {
            int min_height = heights[i];
            int left = i, right = i;
            while(left > 0 && heights[left - 1] >= min_height) {
                left--;
            }

            while(right < length -1 && heights[right + 1] >= min_height) {
                right++;
            }
            int cur_area = (right - left + 1) * min_height;
            max_area = Math.max(cur_area, max_area);
        }
        return max_area;
    }

    /**
     * TODO
     *  巧妙的栈解法: 官网最后两种优解跟这个比就显得弱了
     *  从栈底到栈顶一次存的都是从小到大的数组元素的索引，当遍历到某个heights元素，其高度比栈顶元素小时，
     *  说明当前遍历到的height就是栈顶元素所在矩形的右边界 + 1，而因为从小到大存储，栈顶元素的height > 栈顶第二个元素的height，所以栈顶第二个元素的index就是栈顶元素所在矩形的左边界-1
     *  矩形的宽度 = 当前遍历到的index - 栈顶第二个元素的index - 1
     */
    public int largestRectangleArea_3(int[] heights) {
        int max_area = 0;
        int length = heights.length;
        Deque<Integer> dequeStack = new ArrayDeque<>();
        dequeStack.addLast(-1);
        for(int i=0; i<length; i++) {
            while(dequeStack.peekLast() != -1 && heights[i] <= heights[dequeStack.getLast()]) {
                int cur_area = heights[dequeStack.removeLast()] * ( i - dequeStack.peekLast() - 1 );
                max_area = Math.max(cur_area, max_area);
            }
            dequeStack.addLast(i);
        }

        while(dequeStack.getLast() != -1) {
            /**
             * TODO
             * 这个地方之前写的
             * int cur_area = heights[dequeStack.removeLast()] * (length -1 - dequeStack.peekLast() -1);
             * 实际上不用减一, 求以当前栈顶元素为短板勾勒出矩形的面积，就是应该用：
             * 下个索引值 - 当前栈倒数第二个索引值 - 1
             */
            int cur_area = heights[dequeStack.removeLast()] * (length - dequeStack.peekLast() -1);
            max_area = Math.max(cur_area, max_area);
        }
        return max_area;
    }

    @Test
    public void test(){
        int heights[] = {2,1,5,6,2,3};
        int res = largestRectangleArea(heights);
        System.out.println(res);
    }


}
