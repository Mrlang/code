package DoDoDo.array;

import java.util.*;

/**
 * @author wangliang01 on 2019/2/18 using IDEA.
 * 15. 3Sum  双数和，三数和，三数接近和，四数和
 * https://leetcode-cn.com/problems/3sum/
 * 转换为 1个数  + 另外两个数。注意：答案中不可以包含重复的三元组.所以nums[left] != nums[left+1]且nums[right] != nums[right-1]
 * 遍历数组,作为第一个数,剩下的元素里找另外两个数
 * 5个思路由块至慢
 * 思路1. 将整个数组排序,然后最左边元素和最右边元素求和,看和是否为sum,然后左右指针内移一步且保证nums[left] != nums[left+1]
 * 思路2. 同思路1,但是不需要保证nums[left] != nums[left+1],是用set去除重复解
 * 思路3. 同思路1,但是不需要保证nums[left] != nums[left+1],是用list手动去除重复解
 * 思路4. 不排序,最外层用set去重,剩下的元素进行遍历,放入set,通过set.contains(sum - a)得到符合的两个数
 * 思路5. 同思路4不排序,最外层用arrList手动去重,剩下的元素进行遍历,放入set,通过set.contains(sum - a)得到符合的两个数
 *
 * 其实思路主要就只有两大类:
 * 1. 整个数组需要先排序:左右双指针法逐渐移动,找到符合条件的两个数字
 * 2. 不需要排序:遍历数组,使用set记录需要的另一个数字
 */
public class Array_15_ThreeSum {
    private static int sum = 0;
    public static void main (String[] args) {
        int nums[] = new int[]{-1,0,1,2,-1,-4};

        threeSum(nums);
    }

    /*===============================================================思路1==============================================================*/
    public static List<List<Integer>> threeSum(int[] nums) {
        //TODO: 首要是这个数组必须有序
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            if(i==0 || (i>0 && nums[i] != nums[i-1])) {
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right) {
                    if(nums[i] + nums[left] + nums[right] == sum) {
                        resList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }else if(nums[i] + nums[left] + nums[right] < sum) {
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return resList;
    }

    /*===============================================================思路2==============================================================*/
    public static List<List<Integer>> threeSum2(int[] nums) {
        //TODO 解析: 首要是这个数组必须有序
        Arrays.sort(nums);
        Set<List<Integer>> resList = new HashSet<>();
        for(int i=0; i<nums.length-2; i++) {
            if(i==0 || (i>0 && nums[i] != nums[i-1])) {
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right) {
                    if(nums[i] + nums[left] + nums[right] == sum) {
                        resList.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                        如果resLists是一个set的话，就不用以下去重判断了,set会去重
//                        while(left < right && nums[left] == nums[left+1]) {
//                            left++;
//                        }
//                        while(left < right && nums[right] == nums[right-1]) {
//                            right--;
//                        }
                        left++;
                        right--;
                    }else if(nums[i] + nums[left] + nums[right] < sum) {
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(resList);
    }


    /*===============================================================思路4==============================================================*/
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ansLst = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int sum = -nums[i];
            Set<Integer> set = new HashSet<>();
            for(int j = i+1; j < nums.length; j++) {
                if(j == i) continue;
                if(set.contains(nums[j])) {
                    List<Integer> lst = Arrays.asList(nums[i], nums[j], (-nums[i]-nums[j]));
                    Collections.sort(lst);
                    //TODO 解析:使用list装解,手动去重,比较快
                    if(ansLst.contains(lst)) continue;
                    ansLst.add(lst);
                    continue;
                }
                set.add(sum - nums[j]);
            }
        }
        return ansLst;
    }

    public static List<List<Integer>> first(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<nums.length-2; i++) {
            if(i==0 || (i>0 && nums[i] != nums[i-1])) {
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right) {
                    if(nums[i] + nums[left] + nums[right] == sum) {
                        resList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }else if(nums[i] + nums[left] + nums[right] < sum) {
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return resList;
    }


    /**
     * 双指针法优化，JAVA 2ms，击败100%
     * https://leetcode-cn.com/problems/3sum-closest/solution/shuang-zhi-zhen-fa-you-hua-java-2msji-bai-100-by-t/
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE, left, right, min = Integer.MAX_VALUE;
        for (int k = 0; k < nums.length - 2; k++) {
            left = k + 1;
            right = nums.length - 1;

            // 区间[left,right]内,和最小的值
            int rangeMin = nums[k] + nums[left] + nums[left + 1];
            // 区间[left,right]内,和最大的值
            int rangeMax = nums[k] + nums[right] + nums[right - 1];
            if (rangeMin > target) {
                // 区间最小值比目标大, 没必要寻找区间其他值的和了
                if (rangeMin - target < min) {
                    min = rangeMin - target;
                    result = rangeMin;
                }
            } else if (rangeMax < target) {
                // 区间最大的值比目标还要小,也没必要寻找区间其他值的和了
                if (target - rangeMax < min) {
                    min = target - rangeMax;
                    result = rangeMax;
                }
            } else {
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[k];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        return sum;
                    }
                    if (Math.abs(sum - target) < min) {
                        result = sum;
                        min = Math.abs(sum - target);
                    }
                }
            }
        }
        return result;
    }

}
