class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int num = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[num]){
                int temp = nums[i];
                nums[i] = nums[num];
                nums[num] = temp;
            }else{
                i++;
            }
        }

        int j = 0;
        for(j = 0; j < nums.length; j++){
            if(nums[j] != j){
                break;
            }
        }

        if(j == nums.length){
            return nums.length;
        }

        return j;
    }
}