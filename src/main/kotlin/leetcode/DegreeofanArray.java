package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DegreeofanArray {

    /**
     * https://leetcode.com/problems/degree-of-an-array/
     *
     * 697. Degree of an Array
     * Solved
     * Easy
     * Topics
     * Companies
     * Hint
     * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
     *
     * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,2,3,1]
     * Output: 2
     * Explanation:
     * The input array has a degree of 2 because both elements 1 and 2 appear twice.
     * Of the subarrays that have the same degree:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * The shortest length is 2. So return 2.
     * Example 2:
     *
     * Input: nums = [1,2,2,3,1,4,2]
     * Output: 6
     * Explanation:
     * The degree is 3 because the element 2 is repeated 3 times.
     * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
     *
     * ***/
    public int findShortestSubArray1(int[] nums) {
        // The int is an array of [firstEncounter, lastEncounter, frequency]
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            // If the key does not exist in the map, we put it with the first encounter and last encounter set to the current position, 'i', and the freqency 1
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{i, i, 1});
            }

            // If it does exist, we update the last encounter to the current position and we increase the frequency by 1
            else {
                int[] arr = map.get(nums[i]);
                arr[1] = i;
                arr[2]++;
                map.put(nums[i], arr);
            }
        }
        // Maximim frequency
        int maxFreq = Integer.MIN_VALUE;

        // Minimum distance
        int minDist = Integer.MAX_VALUE;

        // Going through all the values of the HashMap
        for (int[] value : map.values()) {
            // value[0] = the first encounter index
            // value[1] = the last encounter index
            // value[2] = frequency

            // If the frecuency is greater than the maxFreq, then we update it and also set the minDist
            if (value[2] > maxFreq) {
                maxFreq = value[2];
                minDist = value[1] - value[0] + 1;
            }

            // If the frecuency is equal to the current max, we take the minimum between the exiting minDist and the minimum distance for the current value
            else if (value[2] == maxFreq) {
                minDist = Math.min(minDist, value[1] - value[0] + 1);
            }
        }
        return minDist;
    }


    public int findShortestSubArray(int[] nums) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> startIndex = new HashMap<>();
        Map<Integer, Integer> endIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            int no = nums[i];
            if (!startIndex.containsKey(no)) {
                startIndex.put(no, i);
            }
            endIndex.put(no, i);
        }

        int degree = Integer.MIN_VALUE;
        for (Integer key : count.keySet()) {
            degree = Math.max(degree, count.get(key));
        }

        for (Integer key : count.keySet()) {
            if (count.get(key) == degree) {
                int arraySize = endIndex.get(key) - startIndex.get(key) + 1;
                ans = Math.min(ans, arraySize);
            }
        }

        return ans;
    }
}
