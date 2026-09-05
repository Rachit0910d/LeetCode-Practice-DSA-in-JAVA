class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivotIndex(nums);

        if(pivot == -1){
            return findInHalfTry(nums, 0, nums.length - 1,  target);
        }

        if(nums[pivot] == target){
            return pivot;
        }

        int ans = findInHalfTry(nums, 0, pivot - 1, target);

        if(ans == -1){
            ans = findInHalfTry(nums, pivot + 1, nums.length - 1, target);
        }

        return ans;
    }

    private int findInHalfTry(int[] nums, int s, int e, int target){
        while(s <= e){
            int m = s + (e - s) / 2;

            if(nums[m] == target){
                return m;
            } else if(nums[m] > target){
                e = m - 1;
            } else{
                s = m + 1;
            }
        }
        return -1;
    }

    private int findPivotIndex(int[] nums){
        if(nums.length == 0){
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int m = l + (r - l) / 2;
            if(m < r && nums[m] > nums[m + 1]){
                return m;
            } else if(m > l && nums[m] < nums[m - 1]){
                return m - 1;
            } else if(nums[l] >= nums[m]){
                r = m - 1;
            } else{
                l = m + 1;
            }
        }

        return -1;
    }

}