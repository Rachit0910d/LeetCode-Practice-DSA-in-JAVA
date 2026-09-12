class Solution {
    public int maxTwoEvents(int[][] events) {

        // Sort by end time
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int n = events.length;

        // maxValue[i] = maximum value among events[0...i]
        int[] maxValue = new int[n];

        maxValue[0] = events[0][2];

        for (int i = 1; i < n; i++) {
            maxValue[i] = Math.max(maxValue[i - 1], events[i][2]);
        }

        int maxAns = 0;

        for (int i = 0; i < n; i++) {

            // Take only this event
            maxAns = Math.max(maxAns, events[i][2]);

            int currentStart = events[i][0];

            // Find the last event whose end < currentStart
            int left = 0;
            int right = i - 1;
            int bestIndex = -1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (events[mid][1] < currentStart) {
                    bestIndex = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (bestIndex != -1) {
                int sum = events[i][2] + maxValue[bestIndex];
                maxAns = Math.max(maxAns, sum);
            }
        }

        return maxAns;
    }
}