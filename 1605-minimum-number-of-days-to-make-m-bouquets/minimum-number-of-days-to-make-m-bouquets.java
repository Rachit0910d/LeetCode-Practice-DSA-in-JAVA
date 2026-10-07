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

  public int minDays(int[] bloomDay, int m, int k) {

    int l = minElem(bloomDay);
    int h = maxElem(bloomDay);

    if((long)m * k > bloomDay.length){
      return -1;
    }
    while (l < h) {
      int mid = l + (h - l) / 2;
      boolean isAllBloomed = isBloomed(bloomDay, m, k, mid);

      if (isAllBloomed) {
        h = mid;
      } else {
        l = mid + 1;
      }
    }

    return l;
  }


  private boolean isBloomed(int[] arr, int m, int k, int bloomDay) {
    int cosucutiveCount = 0;
    int bouquet = 0;

    for (int bloom : arr) {
      if (bloom <= bloomDay) {
        cosucutiveCount++;

        if (cosucutiveCount == k) {
          bouquet++;
          cosucutiveCount = 0;
        }

        if (bouquet == m) {
          return true;
        }
      } else{
        cosucutiveCount = 0;
      }
    }

    return false;
  }
}