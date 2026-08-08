class Solution {
      public int[] sortedSquares(int[] nums) {
    ArrayList<Integer> nlist = new ArrayList<>();
    ArrayList<Integer> plist = new ArrayList<>();

    for (Integer integer : nums) {
      if(integer <= 0){
        nlist.add(integer);
      } else{
        plist.add(integer);
      }
    }

    for (int i = 0; i < plist.size(); i++) {
      plist.set(i, plist.get(i)*plist.get(i));
    }
    for (int i = 0; i< nlist.size(); i++) {
      nlist.set(i, nlist.get(i)*nlist.get(i));
    }

    Collections.reverse(nlist);

    int i = plist.size() - 1;
    int j = nlist.size() - 1;
    int k = plist.size() + nlist.size() - 1;
    

    while(i >= 0 && j >= 0){
      if(plist.get(i) >= nlist.get(j)){
        nums[k] = plist.get(i);
        i--;
      } else{
        nums[k] = nlist.get(j);
        j--;
      }
      k--;
    }

    while(i >= 0){
      nums[k] = plist.get(i);
      k--;
      i--;
    }

    while(j >= 0){
      nums[k] = nlist.get(j);
      k--;
      j--;
    }

    return nums;
          
  }

}