package neetcode.blind75;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TwoSumProblem {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);

        List<Integer>[] freq = new List[nums.length + 1];

    }


    public static int[] twoSum(int[] nums, int target) {
        int[] numbers = new int[2];
        if (nums.length > 0) {
            for (int x = 0; x <= nums.length - 2; x++) {
                for (int y = x + 1; y < nums.length; y++) {
                    if (nums[x] + nums[y] == target) {
                        numbers[0] = nums[x];
                        numbers[1] = nums[y];
                    }
                }
                break;
            }
        }
        return numbers;

    }
}