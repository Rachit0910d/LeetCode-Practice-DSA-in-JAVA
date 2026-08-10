class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int high = 0, low = 0, sum = 0, res = Integer.MAX_VALUE;

        while(high < nums.length){
            sum += nums[high];

            while(sum >= target){
                int len = high - low + 1;
                res = Math.min(res, len);
                sum -= nums[low];
                low++;
            }
            high++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}