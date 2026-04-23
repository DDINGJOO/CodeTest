import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return new CombinationBuilder(n, k).build();
    }

    private static final class CombinationBuilder {
        private final int n;
        private final int targetSize;
        private final List<List<Integer>> combinations = new ArrayList<>();
        private final List<Integer> current = new ArrayList<>();

        private CombinationBuilder(int n, int targetSize) {
            this.n = n;
            this.targetSize = targetSize;
        }

        private List<List<Integer>> build() {
            backtrack(1);
            return combinations;
        }

        private void backtrack(int start) {
            if (current.size() == targetSize) {
                combinations.add(new ArrayList<>(current));
                return;
            }

            int remaining = targetSize - current.size();
            int lastCandidate = n - remaining + 1;

            for (int value = start; value <= lastCandidate; value++) {
                current.add(value);
                backtrack(value + 1);
                current.removeLast();
            }
        }
    }
}
