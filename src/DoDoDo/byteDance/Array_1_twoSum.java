package DoDoDo.byteDance;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * Created by Mr_liang on 16/8/17.
 *
 * 1. 两数之和
 * 双数和，三数和，三数接近和，四数和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * TODO
 *   思路:新建一个map，以数组元素为键,元素下标为值。从开头遍历给定数组,如果map中contains(sum-当前数组元素),则取出map.get获取其下标和当前元素下标,返回即为所求。
 */
public class Array_1_twoSum {
    public static  void main(String args[]){
        int[] num = {1, 2, 3, 4, 5};
        List<String> list = reslove(num, 5);
        System.out.println(JSON.toJSONString(list));
    }

    /*===============================================================通过映射实现只需一次遍历==============================================================*/
    public static List twoSum(int[] nums, int target) {
        List<String> indexList = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int i=0;
        for(i=0;i<nums.length;i++){
            int x=nums[i];
            if(map.containsKey(target - x)){
                indexList.add(map.get(target - x) + "-" + i);
            }
            map.put(x, i);
        }
        return indexList;
    }

    public static List reslove(int[] nums, int target) {
        List<String> numList = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            int current = nums[i];
            if(set.contains(target - current)) {
                numList.add(target - current + "-" + current);
            } else{
              set.add(nums[i]);
            }
        }
        return numList;
    }

    /*===============================================================排序+双指针==============================================================*/
    @Test
    public void test(){
        // TODO 倒数第二个for循环里break关键;底数第一个for循环里 i != res[0] 是关键；少任何一个都该case都会报错
        twoSum_2(new int[]{1,1}, 2);
    }
    public int[] twoSum_2(int[] nums, int target) {
        int[] res = new int[2];
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyNums);

        int left=0, right=nums.length-1;
        while(left < right) {
            if(copyNums[left] + copyNums[right] > target) {
                right--;
            }else if(copyNums[left] + copyNums[right] < target) {
                left++;
            }else {
                break;
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == copyNums[left]) {
                res[0] = i;
                break;
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == copyNums[right] && i != res[0]) {
                res[1] = i;
            }
        }

        return res;
    }



}

