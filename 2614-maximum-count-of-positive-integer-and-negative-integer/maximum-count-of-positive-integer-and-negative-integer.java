class Solution {
    public int maximumCount(int[] nums) {
        int NegMax = 0;
        int PosMax = 0;
        int start = 0;

        while(start < nums.length){
            if(nums[start] < 0){
                NegMax++;
            }
            if(nums[start] > 0){
                PosMax++;
            }
            start++;
        }
        return Math.max(NegMax, PosMax);
    }
}