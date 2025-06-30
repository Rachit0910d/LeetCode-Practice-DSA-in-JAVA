class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int i = 0;
        int[] ans = new int[2*n];
        while(i < 2*n){
            if(i < n){
                ans[i] = nums[i];
            }
            if(i >= n && i < 2*n){
                ans[i] = nums[i-n];
            }
            i++;
        }
        return ans;
    }
}