package DoDoDo.slide_window;

/**
 * Created by wangliang01 on 2020/7/22 using IDEA.
 *
 * 209. 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *  
 *
 * 进阶：
 *
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class slide_window_209 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        while(right < nums.length) {
            windowSum += nums[right];
            right++;
            while(windowSum >= s) {
                /**
                 * TODO 内层循环必须做够三步，记得，不要丢了某一步了
                 * 1. 更新最值/方法要求的返回值 这一步看情况放到while外面去更新
                 * 2. 更新window数据
                 * 3. left右移
                 */
                minLength = Math.min(right - left , minLength);
                windowSum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
