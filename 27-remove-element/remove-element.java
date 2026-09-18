class Solution {
    public int removeElement(int[] nums, int val) {
        int read = 0, write = 0;
        int count = 0;
        while(read < nums.length){
            if(nums[read] != val){
                nums[write] = nums[read];
                write++;
            } 
            read++;
            
        }

        return write;
    }
}