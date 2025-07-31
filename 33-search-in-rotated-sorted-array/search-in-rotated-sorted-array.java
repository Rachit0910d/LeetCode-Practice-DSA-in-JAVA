class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){    // if array length is one then check directly
            if(nums[0] == target){
                return 0;
            } else{
                return -1;
            }
        }
        int pivot = findingPivot(nums);   // find pivot element

        if(pivot == -1){    // if pivot is not found then do normal binary search
            return firstHalfTry(nums, target, 0, nums.length - 1);
        }

        if(nums[pivot] == target) return pivot; // if pivot element == to the target then return pivot

        int ans = firstHalfTry(nums, target, 0, pivot - 1);  // finding target element in the first half array
        if(ans != -1){
            return ans;   // if you find in first half array then return the index
        } else{
            return firstHalfTry(nums, target, pivot + 1, nums.length - 1);  // if you do not find in the first half array then check in the second half array
        }
    }

     int findingPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        if(arr.length == 0) return -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid + 1]){
                    return mid;
            }
            if( mid > start && arr[mid] < arr[mid -1]){
                return mid - 1;
            }
            if(arr[start] >= arr[mid]){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return -1;
    }

     int firstHalfTry(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target < arr[mid]){
                end = mid - 1;
            } else if(target > arr[mid]){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}