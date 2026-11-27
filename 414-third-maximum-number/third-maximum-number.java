class Solution {
     public int thirdMax(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        for (int i = 0; i < 3 && i < nums.length; i++) {
            if (!minHeap.contains(nums[i]))
                minHeap.offer(nums[i]);
        }

        for (int i = 3; i < nums.length; i++) {
            if (minHeap.contains(nums[i])) 
                continue;

            if (minHeap.size() < 3) {
                minHeap.offer(nums[i]);
                continue;
            }

            if (minHeap.peek() >= nums[i]) {
                continue;
            }

            minHeap.poll();
            minHeap.offer(nums[i]);
        }

        if (minHeap.size() < 3) {
            int max = Integer.MIN_VALUE;

            for (int num : minHeap) {
                max = Math.max(max, num);
            }

            return max;
        }


        return minHeap.peek();
    }
}