class Solution {
      public int longestConsecutive(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    int longest = 0;
    for(int i : nums){
      set.add(i);
    }

    for(int i : set) {
      if(i == Integer.MIN_VALUE || !set.contains(i - 1)){
        int current = i;
        int length = 1;

        while(current != Integer.MAX_VALUE &&
           set.contains(current + 1)){
          length++;
          current++;
        }
        
        longest = Math.max(length, longest);

      }
    }
    return longest;

  }
}