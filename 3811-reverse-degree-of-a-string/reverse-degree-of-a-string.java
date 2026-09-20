class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int asci = (int)s.charAt(i);
            int revInd = 122 - asci + 1;
            sum += revInd * (i + 1);
        }

        return sum;

    }
}