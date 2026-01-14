package neetcode.blind75;

public class MaximumSubArray {
    public static void main(String[] args) {
        int nums[] = {-1,-2,-5,-5};
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        System.out.println(maximumSubArray.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int currentMax=nums[0];
        int maxSoFar=nums[0];

        for(int i=1; i<nums.length; i++){
            currentMax = Math.max(nums[i], nums[i]+currentMax);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }
}
