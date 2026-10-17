class Solution {
    public int hIndex(int[] citations) {
    int l = 0;
    int h = citations.length;
    int ans = -1;

    while (l <= h) {
      int guess = l + (h - l) / 2;
      boolean isTrue = isHIndex(citations, guess);

      if (isTrue) {
        ans = guess;
        l = guess + 1;
      } else {
        h = guess - 1;
      }
    }

    return ans;
  }

  private boolean isHIndex(int[] arr, int guess) {
    int count = 0;

    for (int ele : arr) {
      if (ele >= guess) {
        count++;
      }
    }

    if (count >= guess)
      return true;

    return false;
  }
}