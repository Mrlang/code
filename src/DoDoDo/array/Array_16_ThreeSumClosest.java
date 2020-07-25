package DoDoDo.array;

import java.util.Arrays;

/**
 * @author wangliang01 on 2019/2/18 using IDEA.
 * 双数和，三数和，三数接近和，四数和
 * https://leetcode-cn.com/problems/3sum-closest/
 * 和找到三数之和为target的题目一样。先确定一个数,从剩下数组里找剩下的两个数
 *
 * 解决三数问题的思路：
 * 思路1: 先将数组排序,从剩下数组里找剩下的两个数,分别从两边往中间移动开始找
 * 思路2: 不用排序,耗时更长,通过set.contains(sum - curItem).但是这个不能用来找与target相距最近的,只能用来解决有target相等的题目.所以不符合本题要求
 */
public class Array_16_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int res = nums[0]+nums[1]+nums[n-1];
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){
            int start = i+1, end = n-1;
            while(start < end){
                int sum = nums[i]+nums[start]+nums[end];
                if(Math.abs(target-sum) < Math.abs(target-res)){
                    res = sum;
                }else if(sum < target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return res;
    }

    public int fastest(int[] nums, int target) {
        //TODO: 两个方法的不同点在这儿
        int returnNum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            int left = i+1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //TODO: 两个方法的不同点在这儿
                if(sum == target) return sum;
                if(Math.abs(sum - target) < Math.abs(returnNum - target)) {
                    returnNum = sum;
                }else if(sum < target){
                    left++;
                }else if(sum > target){
                    right--;
                }
            }
        }
        return returnNum;
    }

    public int asd(int[] nums) {
        int curIndex = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[curIndex] != nums[i]) {
                curIndex++;
                nums[curIndex] = nums[i];
            }
        }
        return curIndex++;
    }

    public static void main(String args[]){
               System.out.println(adsfas());
    }

    public static int adsfas() {
        int i =9;
        return i++;
    }
}
