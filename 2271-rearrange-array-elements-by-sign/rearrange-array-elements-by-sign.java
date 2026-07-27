class Solution {
    public int[] rearrangeArray(int[] nums) {
    int[] arr = new int[nums.length];
    int i = 0, j = 1, k =0;
    
    while(k < nums.length){
      if(nums[k] > 0) {
        arr[i] = nums[k];
        i += 2;
      } else{
        arr[j] = nums[k];
        j += 2;
      }
      k++;
    }
    return arr;
  }
}