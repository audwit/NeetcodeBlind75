package neetcode.blind75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {0,3,2,5,4,6,1,1};
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int max=0;
        int min=0;

        // Find the max and min of array O(n)
        if(nums.length>1){
            min=nums[0];
            max=nums[0];
            for(int i=0; i<nums.length; i++){
                if(nums[i]>max)
                    max=nums[i];
                if(nums[i]<min)
                    min=nums[i];
            }
        }
        else
            return 0;

        // Put the array in a HashSet
        Set<Integer> hashset = new HashSet<>();
        Arrays.stream(nums).forEach(num->hashset.add(num));

        int lSeq=0; //Longest sequence found
        int cSeq=0; // Current sequence
        int current;

        current = min;
        while(current<=max){
            if(hashset.contains(current)){
                current++;
                cSeq++;
            }
            else {
                // Now find out the next number in the array that has consecutive numbers
                while (current < max && !hashset.contains(current)) {
                    current++;
                }
                if (cSeq > lSeq)
                    lSeq = cSeq;
                cSeq = 0; // Reset current sequence
            }

        }

        if(cSeq>lSeq)
            lSeq=cSeq;
        return lSeq;

    }
}
