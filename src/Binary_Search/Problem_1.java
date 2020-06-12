package Binary_Search;

public class Problem_1 {

    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 0));
    }

    public static int searchInsert(int [] nums, int target) {

        return searchInsert(nums, target, 0, nums.length - 1);
    }

    public static  int searchInsert(int [] nums, int target, int low, int high) {

        int mid = low + (high - low) / 2;

        if(high == low) {
            if(nums[high] == target) return high;
            if(target > nums[high] ) return high + 1;
            if(target < nums[high]) {
                if (high == 0) return 0;
                else return (high);
            }
        }


        if(high - low == 1)  {
            if(nums[high] == target) return high;
            else if(nums[low] == target) return low;

            else if(target < nums[low]) {
                if(low == 0) return 0;
                else return (low);
            }

            else if(target > nums[low] && target < nums[high]) {
                return low + 1;
            }

            else if(target > nums[high]) return high + 1;

        }


        else if(nums[mid] == target) return mid;

        else if(target > nums[mid]) return searchInsert(nums, target,mid + 1, high);

        else if(target < nums[mid]) return searchInsert(nums, target, low, mid - 1);

        return -1;
    }
}
