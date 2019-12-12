package leetCode.array;

/**
 * Created by wangliang01 on 2019/10/26 using IDEA.
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Array_283_Move_zeros {
    public void moveZeroes(int[] nums) {
        int pos = 0, cur=0;

        while(cur < nums.length) {
            if(nums[cur] == 0) {

            }else {
                nums[pos] = nums[cur];
                pos++;
            }
            cur++;
        }

        for(int i=pos; i<nums.length; i++) {
            nums[i] = 0;
        }
    }
}
