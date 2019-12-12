package leetCode.array;

/**
 * Created by wangliang01 on 2019/9/30 using IDEA.
 * https://leetcode-cn.com/problems/remove-element/submissions/
 *
 */
public class Array_27_Remove_array_element {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int replaceIndex = 0;
        for(int i=0; i<length; i++) {
            if(nums[i] == val){

            }else{
                nums[replaceIndex] = nums[i];
                replaceIndex++;
            }
        }

        return replaceIndex;
    }
}
