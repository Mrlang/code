package DoDoDo.array;

/**
 * 11
 * https://leetcode.com/problems/container-with-most-water/
 * @author wangliang01 on 2019/3/1 using IDEA.
 * 思路:从数组两段元素作为水桶的壁,计算体积=最低壁(Math.min(arr[left], arr[right]))*壁间距离(right-left),注意体积不要计算错误不是两个壁高相乘.
 * 若体积大于当前最大体积,则进行替换。
 * 然后将较低壁移至下一位,计算体积并比较。
 */
public class Array_11_ContainerWithMostWater {
    public static void main(String args[]){
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int max = maxArea(height);
        System.out.println(max);
    }

    public static int maxArea(int[] height) {
        int length = height.length;
        int left = 0, right = length - 1;
        int max = 0;
        int v = 0;
        while(left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right] ) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
