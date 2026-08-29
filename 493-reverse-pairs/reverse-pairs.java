class Solution {
    public int reversePairs(int[] nums) {
        int low = 0; 
        int high = nums.length - 1;

        return mergeSort(nums, low, high);
    }

    public int mergeSort(int[] nums, int low, int high){
        int count = 0;

        if(low >= high) return count;

        int mid = low + (high - low) / 2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);

        count += countPairs(nums, low, mid,  high);

        merge(nums, low, mid,  high);

        return count;
    }

    public int countPairs(int[] nums, int low, int mid, int high){
        int count = 0;
        int j = mid + 1;
        
        for (int i = low; i < mid + 1; i++) {
            while(j <= high && nums[i] > 2L * nums[j]){
                j++;

            }
            count += j - (mid + 1);
        }

        return count;
    }

    public void merge(int[] nums, int low, int mid, int high){
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] ans = new int[high - low + 1];

        while(i <= mid && j <= high){
            if(nums[i] <= nums[j]){
                ans[k] = nums[i];
                i++;
            } else{
                ans[k] = nums[j];
                j++;

            }
            k++;
        }

        while(i <= mid){
            ans[k] = nums[i];
            i++;
            k++;
        }

        while(j <= high){
            ans[k] = nums[j];
            j++;
            k++;
        }

        for (int x = 0; x < ans.length; x++) {
        nums[low + x] = ans[x];
    }
    }

}