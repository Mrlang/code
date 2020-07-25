package DoDoDo.byteDance;

import org.junit.Test;

/**
 * Created by wangliang01 on 2020/7/25 using IDEA.
 *
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class class_215 {
    private int nums[];
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;

        int left = 0, right = nums.length-1;
        int par = par(left, right);
        while(par + 1 != k) {
            if(par + 1 > k) {
                right = par - 1;
            }else if(par + 1 < k) {
                left = par + 1;
            }
            par = par(left, right);
        }


        return nums[par];
    }

    private int par(int begin, int end) {
        int randomNumber = nums[begin];

        int left = begin, right = end;
        while(left < right) {
            //TODO 看第二个case，必须 left < nums.length
            while(left < nums.length && nums[left] >= randomNumber) {
                left++;
            }

            while(nums[right] < randomNumber) {
                right--;
            }

            if(left < right) {
                swap(left, right);
            }

        }
        swap(begin, right);

        return right;
    }

    private void swap(int x, int y) {
        int sum = nums[x] + nums[y];
        nums[x] = nums[y];
        nums[y] = sum - nums[y];
    }

    @Test
    public void test(){
        int a[] = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;



        a = new int[]{99,99};
        k=1;

        System.out.println(findKthLargest(a, 2));


    }
}
