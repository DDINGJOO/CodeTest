import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            int remain = map.getOrDefault(ch, 0);
            if (remain > 0) {
                map.put(ch, remain - 1);
            } else {
                count++;
            }
        }

        return count;
    }
}
