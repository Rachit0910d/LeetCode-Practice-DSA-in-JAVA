class Solution {
    public int maxDepth(String s) {
      int count = 0;
      int MaxCount = 0;

      for (int i = 0; i < s.length(); i++) {
        if(s.charAt(i) != ')'){
          if(s.charAt(i) == '('){
            count++;
            MaxCount = Integer.max(MaxCount, count);
          }
        } else{
          count--;
        }
      }

      return MaxCount;
    }
}