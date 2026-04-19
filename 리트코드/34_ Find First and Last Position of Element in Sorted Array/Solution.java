import java.util.stream.IntStream;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] idx = IntStream.range(0, nums.length)
                .filter(i -> nums[i] == target)
                .toArray();

        return idx.length == 0
                ? new int[]{-1, -1}
                : new int[]{idx[0], idx[idx.length - 1]};
    }
}
