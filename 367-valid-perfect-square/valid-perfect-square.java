class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 0){
            return true;
        }
        if(num <= 2){
            return true;
        }
        int start = 0;
        int end = Math.min(num / 2, 46340);
        while(start <= end){
            int mid = start + (end - start) / 2;
            if((long)(mid*mid) == num){
                return true;
            } else if((long)(mid*mid) < num){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return false;
    }
}