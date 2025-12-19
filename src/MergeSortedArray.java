import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{};
        int m = 1;
        int n = 0;

        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int ptr1 = 0;
        int ptr2 = 0;
        boolean nums1HasMoreElements = false;
        boolean nums2HasMoreElements = false;
        int resultPtr = 0;

        // Edge case: If nums2 is empty, return nums1 as is
        if(m>0 && n >0){
            //Compare elements in both arrays and find the smallest element
            for (resultPtr = ptr1 = 0; ptr1 < m; resultPtr++) {
                if (nums1[ptr1] <= nums2[ptr2]) {
                    result[resultPtr] = nums1[ptr1];
                    ptr1++;
                } else {
                    result[resultPtr] = nums2[ptr2];
                    ptr2++;
                }

                if (ptr1 >= m && ptr2 <= n-1) {
                    nums2HasMoreElements = true;
                    resultPtr++;
                    break;
                }
                if (ptr1 <= m-1 && ptr2 >= n) {
                    nums1HasMoreElements = true;
                    resultPtr++;
                    break;
                }

            }
        }




        //Copy the rest of the elements from nums1 to result array
        if (nums1HasMoreElements || n==0) {
            for (; resultPtr < m+n && ptr2<m; resultPtr++) {
                result[resultPtr] = nums1[ptr1];
                ptr1++;
            }
        }
            if (nums2HasMoreElements || m ==0) {
                for (; resultPtr < m+n && ptr2<n; resultPtr++) {
                    result[resultPtr] = nums2[ptr2];
                    ptr2++;
                }
            }
                // Copy everything from result array to nums1
                for (int x = 0; x < m + n; x++) {
                    nums1[x] = result[x];
                }
            System.out.println(Arrays.toString(nums1));
        }
}