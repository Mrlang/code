package DoDoDo.array;

import java.util.*;

/**
 * @author wangliang01 on 2019/2/18 using IDEA.
 * 18. 4Sum 双数和，三数和，三数接近和，四数和
 * https://leetcode-cn.com/problems/4sum/
 * 和"三数之和"完全一样的思路，只不过多一层嵌套
 */
public class Array_18_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //TODO 使用hashSet保证答案不重复,就不再需要注释里面的去重了
        HashSet<List<Integer>> returnSet = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length - 3; i++) {
            for(int j=i+1; j<nums.length-2; j++) {
                int sum = target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right) {
                    if(nums[left] + nums[right] == sum) {
                        returnSet.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
//                        while(left < right && nums[left] == nums[left + 1]) {
//                            left++;
//                        }
//                        while(left < right && nums[right] == nums[right - 1]) {
//                            right--;
//                        }
                        left++;
                        right--;
                    }else if(nums[left] + nums[right] < sum) {
                        left++;
                    }else {
                        right--;
                    }
                }

            }
        }
        return new ArrayList<>(returnSet);

    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Set<List<Integer>> returnSet = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                int sum = target - nums[i] - nums[j];
                for(int x=j+1; x<nums.length; x++) {
                    Set<Integer> set = new HashSet<>();
                    if(set.contains(sum - nums[x])) {
                        List<Integer> innerList = Arrays.asList(nums[i], nums[j], nums[x], sum - nums[x]);
                        Collections.sort(innerList);
                        returnSet.add(innerList);
                        continue;
                    }else {
                     set.add(nums[x]);
                    }
                }
            }
        }
        return new ArrayList<>(returnSet);
    }
}
