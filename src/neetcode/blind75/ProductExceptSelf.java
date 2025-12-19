package neetcode.blind75;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] inputArray = new int[]{-1,0,1,2,3};
        int[] result= new int[]{};
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        result = productExceptSelf.productExceptSelf(inputArray);
        Arrays.stream(result).forEach(System.out::print);
    }

    public int[] productExceptSelf(int[] nums) {
        int product=1;
        int[] result = new int[nums.length];
        int i=0;
        for(int num:nums){
            if(num!=0)
                product=product*num;

        }
        System.out.println("This is result "+product);

        int countOfZeroes=0;

        for(int num:nums){
            if(num==0)
                countOfZeroes++;
        }

        if(countOfZeroes >= 2)
            return result;

        int j=0;
        if(countOfZeroes==1){
            for(int num:nums){
                if(num==0)
                    result[j]=product;
                else
                    result[j]=0;
                j++;
            }
            return result;
        }

        for(int num:nums){
            if(num!=0)
                result[i]=product/num;
            else
                result[i]=product;
            i++;
        }
        return result;
    }
}
