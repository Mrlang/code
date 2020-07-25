package DoDoDo.monotonic_deque.monotonic_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by wangliang01 on 2020/7/8 using IDEA.
 *
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 进阶：你能在线性时间复杂度内解决此题吗？
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Monotonic_Queue_239_sliding_window_maximum {
//=============================================常规即可=======================================================//
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(length * k == 0) return new int[0];
        int[] res = new int[length - k  + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int j=0;

        for(int i=0; i<length; i++) {
            if(i < k-1) {
                offerLast(deque, nums[i]);
            }else{
                offerLast(deque, nums[i]);
                res[j++] = max(deque);
                removeI(deque, nums[i - k + 1]);
            }
        }

        /*
        // TODO i<length需要改成i<=length,否则res数组的最后一个元素res[length-1]不会被走到
        for(int i=0; i<length; i++) {
            // TODO i<k需要改成i<k-1
            if(i < k) {
                offerLast(deque, nums[i]);
            }else{
                res[j++] = max(deque);
                offerLast(deque, nums[i]);
                removeI(deque, nums[i - k]);
            }
        }
        */

        return res;
    }

    private void offerLast(Deque<Integer> deque, int i) {
        while(!deque.isEmpty() && deque.peekLast() < i) {
            deque.removeLast();
        }
        deque.offerLast(i);
    }

    private void removeI(Deque<Integer> deque, int i) {
        if(!deque.isEmpty() && deque.peekFirst() == i) {
            deque.removeFirst();
        }
    }

    private int max(Deque<Integer> deque) {
        return deque.peekFirst();
    }



//=============================================高阶=======================================================//

    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }

    public int[] maxSlidingWindow_2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

}
