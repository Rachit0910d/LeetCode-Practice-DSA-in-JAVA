class Solution {
    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        int ans = 0;

        if(x == 0) return 0;
        if(x <= 2){
            return 1;
        }

        while(start <= end){
            int mid = start + (end - start) / 2;
            if((long)mid*mid == x){
                return mid;
            } else if((long)mid*mid > x){
                end = mid - 1;
            } else{
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}