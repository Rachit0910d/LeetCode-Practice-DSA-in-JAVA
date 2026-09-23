class Solution {
    public int minOperations(int[] nums, int x) {
    int tSum = 0;
    for(int n : nums){
      tSum += n;
    }

    int target = tSum - x;

    int low = 0;

    int sum = 0;
    int ans = -1;
    for(int high = 0; high < nums.length; high++){
      sum += nums[high];

      while(low <= high && sum > target){
        sum -= nums[low];
        low++;
      }

      if(sum == target){
        ans = Math.max(ans, high - low + 1);
      }
    }
    return ans == -1 ? -1 : (nums.length - ans);
  }
}