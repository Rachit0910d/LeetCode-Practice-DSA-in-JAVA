class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int altitude = 0;
        for(int i = 0; i < gain.length; i++){
            altitude += gain[i];
           max = Math.max(altitude, max);
        }
        return max;
    }
}