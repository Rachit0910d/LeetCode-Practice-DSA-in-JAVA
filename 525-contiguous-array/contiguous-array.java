class Solution {
    public int findMaxLength(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int sum = 0, res = 0;

    for (int i = 0; i < nums.length; i++) {
      if(nums[i] == 0){
        sum++;
      } else{
        sum--;
      }
      
      if(sum == 0){
        res = Math.max(res, i + 1);
        continue;
      }
      
      if(!map.containsKey(sum)){
        map.put(sum, i);
      } else{
        res = Math.max(res, i - map.get(sum));

      }
      
    }
    
    return res;
    
  }
}