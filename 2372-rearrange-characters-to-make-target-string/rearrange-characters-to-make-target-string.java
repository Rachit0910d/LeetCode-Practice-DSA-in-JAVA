class Solution {
    public int rearrangeCharacters(String s, String target) {
      HashMap<Character, Integer> map = new HashMap<>();
      for (Character c : s.toCharArray()) {

        if (!map.containsKey(c)) {
          map.put(c, 1);
        } else {
          map.put(c, map.getOrDefault(c, 1) + 1);
        }
      }

      int minimum = Integer.MAX_VALUE;

      HashMap<Character, Integer> required = new HashMap<>();

      for (char ch : target.toCharArray()) {
        required.put(ch, required.getOrDefault(ch, 0) + 1);
      }

      for (char ch : required.keySet()) {
        if (!map.containsKey(ch)) {
          return 0;
        }

        int possible = map.get(ch) / required.get(ch);
        minimum = Math.min(minimum, possible);
      }

      return minimum;

    }
  }