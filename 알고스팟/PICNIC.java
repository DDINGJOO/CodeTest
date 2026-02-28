package 알고스팟;

import java.util.*;

public class PICNIC {
    public static void main(String[] args) {
        int members = 4;
        int[] nums = {0,1, 1,2, 2,3, 0,3}; // 가능한 짝 목록 (쌍으로)
        Map<Integer, List<Integer>> table = makeTable(members, nums);
        boolean[] paired = new boolean[members];
        int result = countPairings(table, paired);
        System.out.println(result);
    }

    public static Map<Integer, List<Integer>> makeTable(int members, int[] nums) {
        Map<Integer, List<Integer>> table = new HashMap<>();
        for (int i = 0; i < members; i++) table.put(i, new ArrayList<>());
        for (int i = 0; i < nums.length; i += 2) {
            int a = nums[i], b = nums[i + 1];
            table.get(a).add(b);
            table.get(b).add(a);
        }
        return table;
    }

    public static int countPairings(Map<Integer, List<Integer>> table, boolean[] paired) {
        // 아직 짝 안 지은 첫 사람 찾기
        int first = -1;
        for (int i = 0; i < paired.length; i++) {
            if (!paired[i]) { first = i; break; }
        }
        // 모두 짝지어졌으면 1가지 완성
        if (first == -1) return 1;

        int ways = 0;
        for (int partner : table.get(first)) {
            if (!paired[partner]) {
                paired[first] = paired[partner] = true;   // 선택
                ways += countPairings(table, paired);      // 재귀
                paired[first] = paired[partner] = false;  // 백트래킹
            }
        }
        return ways;
    }
}