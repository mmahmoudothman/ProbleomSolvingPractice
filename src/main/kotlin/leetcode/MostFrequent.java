package leetcode;

import java.util.HashMap;

public class MostFrequent {

    public int mostFrequent1(int[] nums, int key) {
        int[] freq = new int[1001];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == key) {
                freq[nums[i]]++;
            }
        }
        int max = 0;
        int maxIndex = 0;
        for (int f = 0; f < freq.length; f++) {
            if (max < freq[f]) {
                max = freq[f];
                maxIndex = f;
            }
        }
        return maxIndex;
    }


    public int mostFrequent(int[] nums, int key) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop through the array, looking for the key and incrementing the count of the element that comes after it
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
            }
        }

        int result = 0; // To store the most frequent element
        int maxCount = -1; // To store the maximum count found

        // Iterate through the map to find the element with the highest count
        for (int num : map.keySet()) {
            int count = map.get(num);
            if (count > maxCount) {
                maxCount = count;
                result = num;
            }
        }

        return result;
    }

}

