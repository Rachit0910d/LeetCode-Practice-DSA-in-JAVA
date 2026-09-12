import java.util.*;

class Solution {

    public int maxTwoEvents(int[][] events) {

        int n = events.length;

        // Sort by starting time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // suffixMax[i] = maximum value from i to n-1
        int[] suffixMax = new int[n];

        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(
                events[i][2],
                suffixMax[i + 1]
            );
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            // Take event i
            int value = events[i][2];

            // Find first event whose start > current end
            int next = findNext(events, events[i][1]);

            // Take current + best compatible event
            if (next < n) {
                value += suffixMax[next];
            }

            ans = Math.max(ans, value);
        }

        return ans;
    }

    private int findNext(int[][] events, int end) {

        int left = 0;
        int right = events.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (events[mid][0] > end) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}