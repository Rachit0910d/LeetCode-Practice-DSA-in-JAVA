class Solution {
    public String restoreString(String s, int[] indices) {
        char[] str = s.toCharArray();
        char[] ans = s.toCharArray();
        for (int i = 0; i < indices.length; i++) {
           ans[indices[i]] = str[i];
        }
        s = new String(ans);
        return s;
    }
}