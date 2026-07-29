class Solution {
    public void nextPermutation(int[] nums) {
    int pivot = 0;
    for (int i = nums.length - 1; i > 0; i--) {
      if(nums[i] > nums[i - 1] ){
        pivot = i-1;

        int j = nums.length -1;

        while(nums[j] <= nums[pivot]) j--;

        int temp = nums[pivot];
        nums[pivot] = nums[j];
        nums[j] = temp;

        pivot +=1;
        int k = nums.length - 1;

        while(pivot < k){
          int temp2 = nums[pivot];
          nums[pivot] = nums[k];
          nums[k] = temp2;
          pivot++;
          k--;
        }
          break;
      }
    }

    if(pivot == 0){
      int j = pivot;
      int k = nums.length - 1;

      while(j < k){
        int temp2 = nums[j];
        nums[j] = nums[k];
        nums[k] = temp2;
        j++;
        k--;
      }
    }
  }

}