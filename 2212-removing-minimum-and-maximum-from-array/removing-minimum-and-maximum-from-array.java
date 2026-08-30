class Solution {
    public int minimumDeletions(int[] nums) {
        int minI = 0;
        int maxI = 0;

        for (int i = 1; i < nums.length; i++) {
            // max
            if (nums[i] > nums[maxI]) {
                maxI = i;
            }

            // min
            if (nums[i] < nums[minI]) {
                minI = i;
            }

        }

        int bothLeft = Math.max(minI, maxI) + 1;

        int bothRight = Math.max(nums.length - minI, nums.length - maxI);

        int leftMinRightMax = (minI + 1) + (nums.length - maxI);

        int leftMaxRightMin = (nums.length - minI) + (maxI + 1);

        return Math.min(Math.min(bothLeft, bothRight), Math.min(leftMaxRightMin, leftMinRightMax));

    }
}