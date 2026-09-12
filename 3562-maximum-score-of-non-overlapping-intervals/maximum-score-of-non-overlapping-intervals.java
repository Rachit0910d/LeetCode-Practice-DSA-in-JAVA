import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0); // left
            arr[i][1] = intervals.get(i).get(1); // right
            arr[i][2] = intervals.get(i).get(2); // weight
            arr[i][3] = i;                       // original index
        }

        // Sort by starting point
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[3], b[3]);
        });

        // Find next non-overlapping interval
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = findNext(arr, arr[i][1]);
        }

        /*
         * dp[i][k]
         *
         * Best result starting from i
         * when we can select at most k intervals.
         */
        Result[][] dp = new Result[n + 1][5];

        // Initialize ALL states
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new Result(0L, new int[0]);
            }
        }

        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                // 1. Skip current interval
                Result skip = dp[i + 1][k];

                // 2. Take current interval
                Result after = dp[next[i]][k - 1];

                // Use long because maximum score can be 4 * 10^9
                long score = (long) arr[i][2] + after.score;

                int[] indices = new int[after.indices.length + 1];

                indices[0] = arr[i][3];

                for (int j = 0; j < after.indices.length; j++) {
                    indices[j + 1] = after.indices[j];
                }

                // Sort original indices for lexicographical comparison
                Arrays.sort(indices);

                Result take = new Result(score, indices);

                dp[i][k] = better(skip, take);
            }
        }

        return dp[0][4].indices;
    }

    private int findNext(int[][] arr, int right) {

        int left = 0;
        int high = arr.length;

        while (left < high) {

            int mid = left + (high - left) / 2;

            // Non-overlapping means start > previous end
            if (arr[mid][0] > right) {
                high = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private Result better(Result a, Result b) {

        // Higher score is better
        if (a.score > b.score) {
            return a;
        }

        if (b.score > a.score) {
            return b;
        }

        // Same score -> lexicographically smaller indices
        if (lexicographicallySmaller(a.indices, b.indices)) {
            return a;
        }

        return b;
    }

    private boolean lexicographicallySmaller(int[] a, int[] b) {

        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {

            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }

        return a.length < b.length;
    }

    static class Result {

        long score;              // CHANGED: int -> long
        int[] indices;

        Result(long score, int[] indices) {  // CHANGED: long
            this.score = score;
            this.indices = indices;
        }
    }
}