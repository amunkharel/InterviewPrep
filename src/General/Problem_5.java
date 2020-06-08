package General;

//Finding Majority Element in the array of numbers using divide and conquer
public class Problem_5 {
    public static void main(String[] args) {
        int [] a = {3,2,3};
        System.out.println(majorityElement(a));
    }

    public static int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    public static int majorityElement(int[] nums, int low, int high) {
        if (low == high) return nums[low];

        int middle = (high + low) / 2;

        int left = majorityElement(nums, low, middle);

        int right = majorityElement(nums, middle + 1, high);

        if(left == right) return left;

        else {
            return countElement(nums, left, right, low, high);
        }
    }

    public static int countElement(int[] nums, int left, int right, int low, int high) {
        int counter1 = 0, counter2 = 0;

        for (int i = low; i <= high; i++) {
            if (nums[i] == left) counter1++;
            if (nums[i] == right) counter2++;
        }

        if (counter1 == counter2) return left;
        else if (counter1 > counter2) return left;
        else return right;
    }
}
