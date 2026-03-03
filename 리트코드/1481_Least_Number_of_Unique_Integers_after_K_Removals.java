  import java.util.*;

  class Solution {
      public int findLeastNumOfUniqueInts(int[] arr, int k) {
          Map<Integer, Integer> map = new HashMap<>();
          for (int n : arr) {
              map.put(n, map.getOrDefault(n, 0) + 1);
          }

          Set<Integer> keys = map.keySet();
          int[][] freq = new int[keys.size()][2]; // [key, count]
          int i = 0;
          for (int key : keys) {
              freq[i][0] = key;
              freq[i][1] = map.get(key);
              i++;
          }

          Arrays.sort(freq, (a, b) -> Integer.compare(a[1], b[1])); // count 오름차순

          for (int j = 0; j < freq.length && k > 0; j++) {
              int key = freq[j][0];
              int count = freq[j][1];

              if (k >= count) {
                  k -= count;
                  map.remove(key);
              } else {
                  break;
              }
          }

          return map.size();
      }
  }