class Solution {
    public int numberOfSteps(int num) {
        return helper(num, 0);
    }

    public int helper(int num, int count){
        if(num % 2 != 0){
            count++;
            num--;
        }
        if(num == 0){
            return count;
        }

        return helper(num / 2, ++count);
    }
}