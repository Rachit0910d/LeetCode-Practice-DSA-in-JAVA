/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIndex(mountainArr);
        int firstHalf = binarySearch(mountainArr, target, 0, peak, true);
        if(firstHalf != -1){
            return firstHalf;
        }
        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }

    public int peakIndex(MountainArray arr){
        int start = 0;
        int end = arr.length() - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(arr.get(mid) < arr.get(mid + 1)){
                start = mid + 1;
            } else{
                end = mid;
            }
        }
        return start;
    }

    public int binarySearch(MountainArray arr, int target, int start, int end, boolean ascending){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr.get(mid) == target){
                return mid;
            }
            if(ascending == true){
                if(target < arr.get(mid)){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            } else{
                if(target < arr.get(mid)){
                    start = mid + 1;
                } else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}