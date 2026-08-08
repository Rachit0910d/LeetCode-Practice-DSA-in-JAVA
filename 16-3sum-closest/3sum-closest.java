class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int resSum = 0;
        int minDiff = Integer.MAX_VALUE;


        for (int i = 0; i < nums.length - 2; i++) {

          int j = i + 1;
          int k = nums.length - 1;
          while(j < k){
            int sum = nums[i] + nums[j] + nums[k];

            int diff = Math.abs(target - sum);

            if(diff < minDiff){
              resSum =  sum;
              minDiff = diff;
            }

            if(sum == target){
              return sum;
            } else if(sum < target){
              j++;
            } else{
              k--;
            }
          }
        }

        return resSum;
    }

}