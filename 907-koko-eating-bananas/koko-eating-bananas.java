class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    int l = 1;
    int r = maxElem(piles);
    int res = -1;

    while(l <= r){
      int guess = l + (r-l)/2;
      long calH = helper(piles, guess);

      if(calH > h){
        l = guess + 1;
      } else{
        res = guess;
        r = guess - 1;
      }

    }
    return res;
  }

  private long helper(int[] arr, int speed){
    long sum = 0;

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i]/speed;
      
      if(arr[i] % speed != 0){
        sum++;
      }
    }

    return sum;
  }

  private int maxElem(int[] arr){
    int max = arr[0];
    for (int i : arr) {
      if(max < i){
        max = i;
      }
    }
    return max;
  }
}