class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int num = nums[i] - 1;
            if(nums[i] != nums[num] && nums[i] < nums.length){
                int temp = nums[i];
                nums[i] = nums[num];
                nums[num] = temp;
            }else{
                i++;
            }
        }
        int j = 0;
        while(j < nums.length){
            if(nums[j] != j + 1){
                break;
            }
            j++;
        }
        return nums[j];
    }
}