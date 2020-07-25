package DoDoDo.array;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 
 * https://leetcode-cn.com/problems/two-sum/
 * 双数和，三数和，三数接近和，四数和
 * Created by Mr_liang on 16/8/17.
 * 思路:新建一个map，以数组元素为键,元素下标为值。从开头遍历给定数组,如果map中contains(sum-当前数组元素),则取出map.get获取其下标和当前元素下标,返回即为所求。
 */
public class Array_1_twoSum {
    public static  void main(String args[]){
        int[] num = {1, 2, 3, 4, 5};
        List<String> list = reslove(num, 5);
        System.out.println(JSON.toJSONString(list));
    }

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

}

