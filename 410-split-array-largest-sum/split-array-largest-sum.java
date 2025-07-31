class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for (int j : nums) {
            start = Math.max(start, j);
            end += j;
        }

        while (start < end){
            int mid = start + (end - start) / 2;

            int sum = 0;
            int pieces = 1;
            for(int num : nums){
                if((sum + num) > mid){
                    // cannot fill the next element in the same subArray
                    // we have to create a new subArray to fill next element in that subArray
                    sum = num;
                    pieces++;
                } else{
                    sum += num;
                }
            }
            if(pieces > k) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}