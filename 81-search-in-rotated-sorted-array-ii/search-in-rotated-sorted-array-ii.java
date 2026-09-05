class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
       int low = 0, high = n-1;

       while (low <= high) {
            int mid = (low+high)/2;
            if (nums[mid] == target) return true;

            if (nums[low]==nums[mid] && nums[mid]==nums[high]) {
                low++;
                high--;
                continue;
            }

            // check if left half is sorted
            if (nums[low] <= nums[mid]) {
                // check if the target lies in the sorted left half
                if (nums[low]<=target && target<=nums[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            // Otherwise, the right half is sorted
            else {
                //check if the target lies in the sorted right half
                if (nums[mid]<=target && target<=nums[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
        }
        }
        return false;
    }

}