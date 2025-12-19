public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3};
        System.out.println(returnMajorityElement(nums));

    }
    public static int returnMajorityElement(int[] nums) {
        int[] nums2 = new int[nums.length+1];
        if (nums.length > 0) {
            for (int i = 0; i < nums.length+1; i++) {
                nums2[nums[i]] = nums2[nums[i]]+1;
            }

            for (int j = 0; j < nums2.length; j++)
                if (nums2[j] >= nums2.length / 2)
                    return j;
        }
        else
            return 0;
        return 0;
    }
}
