class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int n = arr.length;
        int[] best = new int[n];

        Arrays.fill(best, Integer.MAX_VALUE);

        int prefix = 0;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            prefix += arr[i];

            // Carry the previous shortest length
            if (i > 0) {
                best[i] = best[i - 1];
            }

            if (map.containsKey(prefix - target)) {

                int start = map.get(prefix - target);
                int len = i - start;

                // Previous subarray must end before 'start'
                if (start >= 0 &&
                    best[start] != Integer.MAX_VALUE) {

                    answer = Math.min(
                        answer,
                        best[start] + len
                    );
                }

                // Current subarray becomes a candidate
                best[i] = Math.min(best[i], len);
            }

            map.put(prefix, i);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}