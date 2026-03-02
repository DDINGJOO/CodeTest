import java.util.*;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> diagonals = new HashMap<>();
        int totalCount = 0;
        int maxDiagonal = 0;

        for (int r = 0; r < nums.size(); r++) {
            List<Integer> row = nums.get(r);
            totalCount += row.size();

            for (int c = 0; c < row.size(); c++) {
                int diagonal = r + c;
                diagonals.computeIfAbsent(diagonal, k -> new ArrayList<>()).add(row.get(c));
                maxDiagonal = Math.max(maxDiagonal, diagonal);
            }
        }

        int[] result = new int[totalCount];
        int index = 0;

        for (int diagonal = 0; diagonal <= maxDiagonal; diagonal++) {
            List<Integer> values = diagonals.get(diagonal);
            if (values == null) {
                continue;
            }

            for (int i = values.size() - 1; i >= 0; i--) {
                result[index++] = values.get(i);
            }
        }

        return result;
    }
}
