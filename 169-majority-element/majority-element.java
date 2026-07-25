class Solution {
    public int majorityElement(int[] nums) {
        int i = 0, count = 0, candidate = 0, current = 0;

        while(i < nums.length){
            current = nums[i];
            if(count == 0){
                candidate = current;
                count++;
            } else if(current == candidate){
                count++;
            } else{
                count--;
            }
            i++;
        }
        return candidate;
    }
}