class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] prefixMax = new int[nums.length];
        int[] suffixMin = new int[nums.length];

        prefixMax[0] = nums[0];
        suffixMin[nums.length - 1] = nums[nums.length - 1];

        for(int i = 1; i < nums.length; i++){
            prefixMax[i] = Math.max(nums[i], prefixMax[i-1]);
        }

        for(int i = nums.length - 2; i >=0; i--){
            suffixMin[i] = Math.min(nums[i], suffixMin[i+1]);
        }

        for(int i = 0; i < nums.length; i++){
            if((prefixMax[i] - suffixMin[i]) <= k){
                return i;
            }
        }

        return -1;
    }
}