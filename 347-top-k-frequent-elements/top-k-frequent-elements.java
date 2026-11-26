class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(map.get(a), map.get(b)));

        for (int i : map.keySet()) {

            if (minHeap.size() < k) {
                minHeap.add(i);
                continue;
            }
            if (map.get(minHeap.peek()) >= map.get(i)) {
                continue;
            }
            minHeap.remove();
            minHeap.add(i);
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.remove();
        }

        return ans;
    }
}