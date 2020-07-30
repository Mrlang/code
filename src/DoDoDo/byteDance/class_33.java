package DoDoDo.byteDance;

import org.junit.Test;

/**
 * Created by wangliang01 on 2020/7/25 using IDEA.
 *
 * 33. 搜索旋转排序数组
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class class_33 {
    private int[] nums;
    private int target;


    /*===============================================================常规解法，边界看清除，背下来就行了==============================================================*/
    public int search_0(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while(left <= right) {
            int midIndex = (left + right) / 2;
            int midNum = nums[midIndex];

            if(midNum == target) {
                return midIndex;
            }

            //TODO <=这个要记得，自己写的时候忘了=，结果差别很大会fail的
            if(nums[left] <= midNum) {
                //TODO target<midNum就行了，如果target = midNum的话，在上面就被return midIndex了;
                if(target >= nums[left] && target < midNum) {
                    right = midIndex - 1;
                }else{
                    left = midIndex + 1;
                }
            //TODO 只要左半段不是递增的，右边半段必定是递增的(因为旋转点必定在左边半段，从旋转点往右还是递增的)
            }else {
                if (target > midNum && target <= nums[right]) {
                    left = midIndex + 1;
                } else {
                    right = midIndex - 1;
                }
            }
        }

        return -1;
    }

    /*===============================================================常规解法2，别人的==============================================================*/
    public int search_1(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while(left <= right) {
            int midIndex = (left + right) / 2;
            int midNum = nums[midIndex];

            if(midNum == target) {
                return midIndex;
            }

            //TODO 本质是一样的，判断只要左边比midNum小，就说明左边半段是递增的
            if(nums[0] <= midNum) {
                if(target >= nums[0] && target < midNum) {
                    right = midIndex - 1;
                }else{
                    left = midIndex + 1;
                }
            }else {
                if (target > midNum && target <= nums[nums.length - 1]) {
                    left = midIndex + 1;
                } else {
                    right = midIndex - 1;
                }
            }
        }

        return -1;
    }

    /*===============================================================常规解法，自己写的，但是用递归而不是while循环，草率了==============================================================*/
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        return searchIndex(0, nums.length -1);
    }

    public int searchIndex(int begin, int end) {
        if(begin > end) {
            return -1;
        }

        int midIndex = (begin + end) / 2;
        int midNum = nums[midIndex];
        if(midNum == target) {
            return midIndex;
        }

        if(nums[begin] <= midNum ) {
            if(target < nums[midIndex] && target >= nums[begin]) {
                return searchIndex(begin, midIndex-1);
            }else{
                return searchIndex(midIndex+1, end);
            }
        }else{
            if(target > nums[midIndex] && target <= nums[end]) {
                return searchIndex(midIndex+1, end);
            }else {
                return searchIndex(begin, midIndex-1);
            }
        }
    }

    /*===============================================================junit==============================================================*/
    @Test
    public void test(){
        int[] a = new int[]{4,5,6,7,0,1,2};
        int target = 3;

        a = new int[]{5,1,3};
        target = 5;

        a = new int[]{3,1};
        target = 1;


        int res = search(a, target);
        System.out.println(res);
    }

}
