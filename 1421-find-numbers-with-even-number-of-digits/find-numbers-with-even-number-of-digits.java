class Solution {
    public int findNumbers(int[] nums) {
        int ans = evenNumber(nums);
        return ans;
    }

    private int evenNumber(int[] nums){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(digits(nums[i]) % 2 == 0){
                count++;
            }
        }
        return count;
    }

    private int digits(int number){
        int count = 0;
        while(number > 0){
            count++;
            number /= 10;
        }
        return count;
    }
}