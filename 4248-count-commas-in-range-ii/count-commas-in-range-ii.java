class Solution {

    public long countCommas(long n) {

        long ans = 0;

        long s= 1000;
        long cs = 1;

        while (s <= n) {

            long e = s * 1000 - 1;

            long l = Math.min(n, e);


            ans += (l - s + 1)*cs;

            s *= 1000;
            cs++;
        }

        return ans;
    }
}