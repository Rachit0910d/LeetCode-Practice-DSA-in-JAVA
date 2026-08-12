class Solution {
    public int lengthOfLongestSubstring(String s) {
        int high = 0, low = 0, maxLen = Integer.MIN_VALUE;
        int[] arr = new int[256];

        for (high = 0; high < s.length(); high++) {
            arr[s.charAt(high)]++;
            
            while(arr[s.charAt(high)] > 1){
                arr[s.charAt(low)]--;
                low++;
                
            }
            int len = high - low + 1;
            maxLen = Math.max(maxLen, len);

        }

        return maxLen > 0 ? maxLen : 0;
    }
}