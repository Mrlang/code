package DoDoDo.array;

/**
 * Created by wangliang01 on 2019/10/25 using IDEA.
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Array_53_Maximum_subarray {

    /**
     * https://leetcode-cn.com/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int beforeSum = nums[0];

        for (int i=1; i<nums.length; i++) {
            //beforeSum = Math.max(beforeSum + nums[i], nums[i]);
            if(beforeSum < 0) {
                beforeSum = nums[i];
            }else {
                beforeSum += nums[i];
            }


            maxSum = Math.max(maxSum, beforeSum);
        }

        return maxSum;
    }

    public int maxSubArray_2(int[] nums) {
        int sum = 0;
        int max = nums[0];

        for (int num : nums) {
            if(sum > 0) {
                sum += num;
            }else {
                sum = num;
            }

            max = Math.max(max, sum);
        }



        return max;
    }
}
