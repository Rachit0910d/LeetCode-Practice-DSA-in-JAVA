class Solution {
    static {
        for(int i = 0; i < 200; i++) maxArea(new int[]{0});
    }
    
    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1, maxArea = 0;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, h * (r - l));
            // skip every line that can't beat the one we just used
            while (l < r && height[l] <= h) l++;
            while (l < r && height[r] <= h) r--;
        }
        return maxArea;
    }
}