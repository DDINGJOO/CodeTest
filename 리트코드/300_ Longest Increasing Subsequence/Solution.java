import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> smallestTailByLength = new ArrayList<>();
        Arrays.stream(nums).forEach(value -> place(value, smallestTailByLength));
        return smallestTailByLength.size();
    }

    private void place(int value, List<Integer> smallestTailByLength) {
        int insertionPoint = Collections.binarySearch(smallestTailByLength, value);

        if (insertionPoint < 0) {
            insertionPoint = -insertionPoint - 1;
        }

        if (insertionPoint == smallestTailByLength.size()) {
            smallestTailByLength.add(value);
            return;
        }

        smallestTailByLength.set(insertionPoint, value);
    }
}
