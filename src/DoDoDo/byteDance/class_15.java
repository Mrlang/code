package DoDoDo.byteDance;

import java.util.*;

/**
 * Created by wangliang01 on 2020/7/25 using IDEA.
 *
 * 15. 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class class_15 {
    private int[] numArray;

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retList = new LinkedList<>();
        this.numArray = nums;

        for(int i=0; i<nums.length; i++) {
            List<List<Integer>> singleRet = twoSum(i);
            if(singleRet != null || singleRet.size() > 0) {
                retList.addAll(singleRet);
            }
        }

        return retList;
    }

    private List<List<Integer>> twoSum(int i) {
        int target = 0 - numArray[i];
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> singleRet = new LinkedList<>();

        for(int index=0; index<numArray.length; index++) {
            int curNum = numArray[index];
            if(index == i) {
                continue;
            }

            if(map.containsKey(curNum)) {
                TreeSet<Integer> list = new TreeSet<>();
                list.add(numArray[i]);
                list.add(curNum);
                list.add(target - curNum);
                singleRet.add((List<Integer>) list);
            }else{
                map.put(target - curNum, null);
            }
        }

        return singleRet;
    }
}
