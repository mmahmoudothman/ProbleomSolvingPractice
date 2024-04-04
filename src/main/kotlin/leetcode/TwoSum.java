package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

    }

    public int[] twoSum1(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length; j++) {
                if (i != j && target - nums[i] == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(target - nums[i]))
                map.put(nums[i], i);
            else {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
        }
        return result;
    }

}
