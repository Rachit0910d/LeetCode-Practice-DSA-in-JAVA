class Solution {
   public List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> list = new ArrayList<>();

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {

      if (i > 0 && nums[i] == nums[i - 1])
        continue;

      int current = -nums[i];

      int j = i + 1;
      int k = nums.length - 1;

      while (j < k) {

        int sum = nums[j] + nums[k];

        if (sum == current) {

          list.add(Arrays.asList(nums[i], nums[j], nums[k]));

          j++;
          k--;

          while (j < k && nums[j] == nums[j - 1])
            j++;

          while (j < k && nums[k] == nums[k + 1])
            k--;

        } else if (sum < current) {
          j++;
        } else {
          k--;
        }
      }
    }

    return list;
  }



}