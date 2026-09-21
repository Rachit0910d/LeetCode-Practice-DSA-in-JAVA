class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int mod = num % k;
            long[] newDp = new long[k];

            // Start a new subarray with the current element
            newDp[mod]++;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {
                int newMod = (int) ((1L * r * mod) % k);

                newDp[newMod] += dp[r];
            }

            // Count all subarrays ending at this index
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            // Move to the next index
            dp = newDp;
        }

        return result;
    }
}