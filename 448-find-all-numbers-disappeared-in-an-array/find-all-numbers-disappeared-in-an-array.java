class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int i = 0;
        while(i < nums.length){
            int num = nums[i] - 1;
            if(nums[i] <= nums.length && nums[i] != nums[num]){
                int temp = nums[i];
                nums[i] = nums[num];
                nums[num] = temp;
            }else{
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if(j !=  nums[j] - 1){
                ans.add(j+1);
            }
        }
        return ans;
    }
}