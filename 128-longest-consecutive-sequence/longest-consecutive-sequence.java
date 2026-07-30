class Solution {
      public int longestConsecutive(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    int longest = 0;
    for(int i : nums){
      set.add(i);
    }

    for(int i : set) {
      if(!set.contains(i-1)){
        int current = i;
        int length = 1;

        while(set.contains(current+1)){
          length++;
          current++;
        }
        
        longest = Math.max(length, longest);

      }
    }
    return longest;

  }
}