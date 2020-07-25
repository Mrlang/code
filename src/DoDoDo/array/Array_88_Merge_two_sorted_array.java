package DoDoDo.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * Created by wangliang01 on 2019/10/25 using IDEA.
 * 题目：合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Array_88_Merge_two_sorted_array {
    @Test
    public void test(){
        int nums1[] = new int[10];


        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;
        nums1[3] = 0;
        nums1[4] = 0;
        nums1[5] = 0;
//        = {1,2,3,0,0,0};
        int nums2[] = new int[]{2,5,6};

        int nums3[] = new int[]{0};
        int nums4[] = new int[]{1};

        System.out.println(JSON.toJSONString(nums1));
        //merge(nums1, 3, nums2, 3);
        merge(nums3, 0, nums4, 1);
        System.out.println(JSON.toJSONString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1;
        int curIndex = m + n - 1;
        while(i>=0 && j >=0 && curIndex>=0) {
            if(nums1[i] >= nums2[j]) {
                nums1[curIndex] = nums1[i];
                i--;
            }else {
                nums1[curIndex] = nums2[j];
                j--;
            }
            curIndex--;
        }

        if(i<0) {
            while(j>=0) {
                nums1[curIndex] = nums2[j];
                curIndex--;
                j--;
            }
        }
    }
}
