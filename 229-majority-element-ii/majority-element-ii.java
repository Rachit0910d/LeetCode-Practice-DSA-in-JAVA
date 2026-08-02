class Solution {
    public List<Integer> majorityElement(int[] nums) {
    int i = 0, count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 0;
    List<Integer> list = new ArrayList<>();

    while(i < nums.length){
      int current = nums[i];

      if(current == candidate1){
        count1++;
      } else if(current == candidate2){
        count2++;
      }
      else{
        if (count1 == 0) {
          candidate1 = current;
          count1++;

        }else if( count2 == 0){
          candidate2 = current;
          count2++;

        } else {
          count1--;
          count2--;
        }
      }

      i++;
    }

    count1 = 0;
    count2 = 0;

    for(int num: nums){
        if(num == candidate1){
            count1++;
        } else if(num == candidate2){
            count2++;
        }
    }

    if(count1 > nums.length / 3){
      list.add(candidate1);
    }
    if(count2 > nums.length / 3){
      list.add(candidate2);

    }
    return list;
  }

}