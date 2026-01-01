package neetcode.blind75;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,2,4,6,8};
        int result;
        BinarySearch binarySearch = new BinarySearch();
        result = binarySearch.search(nums, 4);
        System.out.println("Result is: " +result);
    }
    public int search(int[] nums, int target) {
        int result;
        int start = 0;
        int end = nums.length-1;
        result = binSearch(nums, target, start, end);
        return result;
    }

    public int binSearch(int[] nums, int target, int start, int end){
        int result=-1;
        int partitionIndex;

        if(nums.length==1)
        {
            if(nums[0]!=target)
                return -1;
            else
                return 0;
        }


        partitionIndex = getPartitionIndex(start, end);
        if(target<nums[partitionIndex] && target>nums[start]){
            end = partitionIndex;
            result = binSearch(nums, target, start, end);
        }
        else if(target==nums[start]){
            result = 0;
            return result;
        }
        else if(target>nums[partitionIndex+1] && target<nums[end]){
//            int[] rightArray = new int[nums.length-partitionIndex-1];
//            rightArray = Arrays.copyOfRange(nums,partitionIndex+1,nums.length);
            start =partitionIndex+1;
            result = binSearch(nums, target, start, end);
        }
        else if(target==nums[end]){
            result = nums.length-1;
            return result;
        }
        else if(target==nums[partitionIndex]){
            result=partitionIndex;
            return result;
        }
        else if(target==nums[partitionIndex+1]){
            result=partitionIndex+1;
            return result;
        }
        else{
            result = -1;
            return result;
        }

        return result;
    }

    int getPartitionIndex(int start, int end){
        int partitionIndex;
        partitionIndex = ((end+start)/2);
        return partitionIndex;
    }
}
