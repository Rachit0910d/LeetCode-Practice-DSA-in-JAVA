class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, 0, target, nums.length - 1);
    }

    public int helper(int[] nums, int start, int target, int end){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(target == nums[mid]){
            return mid;
        }
        if(target < nums[mid]){
            return helper(nums, start, target, mid - 1);
        }else{
            return helper(nums, mid + 1, target, end);
        }
    }
}