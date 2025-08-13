class Solution {
    public void reverseString(char[] s) {
       char[] ans = helper(s, 0, s.length - 1);
       System.out.println(Arrays.toString(ans));
    }

    public char[] helper(char[] s, int start, int end){
        if(start > end){
            return s;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        return helper(s, ++start, --end);
    }
}