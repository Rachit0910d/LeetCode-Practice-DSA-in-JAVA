class Solution {
    public int[] nextGreaterElements(int[] nums) {
    int[] ans = new int[nums.length];
    Arrays.fill(ans, -1);
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < 2*nums.length; i++) {
      int currIdx = i % nums.length;

      while(!st.isEmpty() && nums[currIdx] > nums[st.peek()]){
        ans[st.pop()] = nums[currIdx];
      }

      if(i < nums.length){
        st.push(i);
      }
    }

    return ans;
  }
}