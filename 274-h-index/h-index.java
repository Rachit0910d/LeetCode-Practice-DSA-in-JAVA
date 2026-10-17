class Solution {
    private int maxElem(int[] arr) {
    int max = arr[0];
    for (int i : arr) {
      if (max < i) {
        max = i;
      }
    }
    return max;
  }

  private int minElem(int[] arr) {
    int min = arr[0];

    for (int i : arr) {
      if (min > i) {
        min = i;
      }
    }
    return min;
  }

    public int hIndex(int[] citations) {
    int l = 0;
    int h = citations.length;
    int ans = 0;

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