package General;
import java.util.*;

//Problem to find total sum of maximum sub-array
public class Problem_4 {
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    public static int maxSubArray(int [] nums, int low, int high) {
        //Base Case
        if(high == low) {
            return nums[low];
        }

        else {
            int middle = (high + low) / 2;

            return Math.max(Math.max(maxSubArray(nums, low, middle),
                    maxSubArray(nums, middle + 1, high)),
                    maximumCrossingSum(nums, low, middle, high));

        }
    }

    public static int maximumCrossingSum(int [] nums, int low, int middle, int high) {
        int sum = 0;

        int left_sum = Integer.MIN_VALUE;

        for(int i = middle; i >= low; i--) {
            sum += nums[i];

            if(sum > left_sum) {
                left_sum = sum;
            }
        }

        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int j = middle + 1; j <= high; j++) {
            sum += nums[j];

            if(sum > right_sum) {
                right_sum = sum;
            }
        }

        return Math.max(left_sum + right_sum, Math.max(left_sum, right_sum));
    }
}
