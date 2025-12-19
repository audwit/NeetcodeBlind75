package neetcode.blind75;

import java.util.Arrays;

public class TwoIntegerSum {
    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,3,4};
        int target = 3;
        TwoIntegerSum twoIntegerSum = new TwoIntegerSum();
        Arrays.stream(twoIntegerSum.twoSum(numbers,target)).forEach(System.out::println);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i=0;
        int j;
        j=numbers.length-1;
        while(i<j){
            if(numbers[i] + numbers[j] > target)
                j--;
            else if(numbers[i] + numbers[j] < target)
                i++;
            else{
                result[0] = i+1;
                result[1] = j+1;
                break;
            }

        }
        return result;
    }
}
