package leetCode.array;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangliang01 on 2019/9/30 using IDEA.
 * 下一个排列。将给定数字序列重新排列成字典序中下一个更大的排列。如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Array_31_The_Next_Permutation {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int i = length - 2;
        while(i>=0 && nums[i] >= nums[i+1]) {
            i--;
        }

        int j = length-1;
        if(i>=0) {
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, j, i);
        }

        reverse(nums, i+1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length-1;
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String args[]){
        Map<Long, String> a = new HashMap<>();
        a.put(123L, "123");
        String jsonString = JSON.toJSONString(a);
        System.out.println(JSON.toJSONString(JSON.parseObject(jsonString, Map.class)));
    }
}
