import java.util.HashMap;
import java.util.Map;

class SparseVector {
    private final Map<Integer, Integer> nonZero = new HashMap<>();

    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZero.put(i, nums[i]);
            }
        }
    }

    public int dotProduct(SparseVector vec) {
        Map<Integer, Integer> a = this.nonZero;
        Map<Integer, Integer> b = vec.nonZero;

        if (a.size() > b.size()) {
            Map<Integer, Integer> tmp = a;
            a = b;
            b = tmp;
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : a.entrySet()) {
            Integer other = b.get(entry.getKey());
            if (other != null) {
                result += entry.getValue() * other;
            }
        }
        return result;
    }
}
