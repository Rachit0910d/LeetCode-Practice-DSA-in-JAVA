class Solution {
    public boolean search(int[] nums, int target) {
        if(nums[0] == target){
            return true;
        }
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return true;
            } else if(nums[mid] > target){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return false;
    }
}