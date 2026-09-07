class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;

        long count = 1;  // includes empty subsequence

        long[] last = new long[26];

        for (char c : s.toCharArray()) {
            int index = c - 'a';

            long oldCount = count;

            count = (2 * count - last[index] + MOD) % MOD;

            last[index] = oldCount;
        }

        return (int) ((count - 1 + MOD) % MOD);
    }
}