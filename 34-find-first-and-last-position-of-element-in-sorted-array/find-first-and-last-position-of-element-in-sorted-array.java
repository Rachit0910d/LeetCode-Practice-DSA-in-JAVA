class Solution {
    
    public int[] searchRange(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        int leftO = -1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                leftO = m;
                r = m - 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        l = 0;
        r = nums.length - 1;
        int rightO = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                rightO = m;
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return new int[] { leftO, rightO };

    }



}