package neetcode.blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
public static void main(String[] args) {
    int[] nums = {4,5,6};
    int target = 10;
    TwoSum ts = new TwoSum();
    int[] result;
    result = ts.twoSum(nums, target);
    Arrays.stream(result).forEach(System.out::println);
}

public int[] twoSum(int[] nums, int target) {
    int[] indexes = new int[2];

    for (int i = 0; i < nums.length - 1; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                indexes[0] = i;
                indexes[1] = j;
            }

        }
    }
    return indexes;
}

    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int x;
        //Add all the numbers to the hashmap
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++){
            x = target-nums[i];
            if(map.containsKey(x) && map.get(x)!= i)
                return new int[]{i, map.get(x)};
        }
        return new int[]{0};
    }
}