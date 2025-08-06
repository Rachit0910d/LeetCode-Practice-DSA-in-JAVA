/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 0;
        int end = n;
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            boolean isBad = isBadVersion(mid);
            if(isBad){
                if(isBadVersion(mid - 1) && mid > 1){
                    end = mid - 1;
                } else{
                    return mid;
                }
            } else{
                ans = start;
                start = mid + 1;
            }
        }
        return ans;
        
    }
}