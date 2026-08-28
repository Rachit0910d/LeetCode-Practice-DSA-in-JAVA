class Solution {
    public int reverse(int x) {
    long y = 0;
    if (x < 0)
      y = -(long) x;
    else
      y = x;
    long rev = 0;

    while (y != 0) {
      long i = y % 10;

      rev = rev * 10 + i;

      y /= 10;

    }

    if (rev > Integer.MAX_VALUE ||
        (rev < Integer.MIN_VALUE)) {
      return 0;
    }

    if (x < 0) {
      return (int) -rev;
    }

    return (int) rev;

  }



}