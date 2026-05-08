import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        return numbers.stream()
                .filter(num -> !numbers.contains(num - 1))
                .mapToInt(num -> {
                    int current = num;
                    int length = 1;
                    while (numbers.contains(current + 1)) {
                        current++;
                        length++;
                    }
                    return length;
                })
                .max()
                .orElse(0);
    }
}
