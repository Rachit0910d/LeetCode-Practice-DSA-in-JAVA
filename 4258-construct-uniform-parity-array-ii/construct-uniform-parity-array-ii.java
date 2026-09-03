class Solution {
    public boolean uniformArray(int[] nums1) {

        int smallestOdd = Integer.MAX_VALUE;
        boolean allEven = true;

        // Find the smallest odd number
        for (int num : nums1) {
            if (num % 2 != 0) {
                smallestOdd = Math.min(smallestOdd, num);
                allEven = false;
            }
        }

        // Already all even
        if (allEven) {
            return true;
        }

        // Check whether every even number
        // is greater than the smallest odd
        for (int num : nums1) {
            if (num % 2 == 0 && num <= smallestOdd) {
                return false;
            }
        }

        return true;
    }
}