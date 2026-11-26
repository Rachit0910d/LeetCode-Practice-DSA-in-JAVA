class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (map.get(a).equals(map.get(b))) {
                    return b.compareTo(a);
                }

                return Integer.compare(map.get(a), map.get(b));
            }
        );

        for (String word : map.keySet()) {
            minHeap.add(word);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        LinkedList<String> ans = new LinkedList<>();

        while (!minHeap.isEmpty()) {
            ans.addFirst(minHeap.poll());
        }

        return ans;
    }
}