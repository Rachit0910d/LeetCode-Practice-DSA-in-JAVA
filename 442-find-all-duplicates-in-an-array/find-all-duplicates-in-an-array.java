class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int num = nums[i] - 1;
            if(nums[i] != nums[num] && nums[i] <= nums.length){
                int temp = nums[i];
                nums[i] = nums[num];
                nums[num] = temp;
            } else{
                i++;
            }
        }

        int j = 0;
        List<Integer> ans = new ArrayList<>();
        while(j < nums.length){
            if(nums[j] != j + 1){
                ans.add(nums[j]);
            }
            j++;
        }
        return ans;
    }
}