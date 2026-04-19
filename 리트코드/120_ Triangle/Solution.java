import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        return IntStream.range(0, n - 1)
                .map(i -> n - 2 - i)
                .boxed()
                .reduce(
                        triangle.get(n - 1),
                        (dp, i) -> IntStream.rangeClosed(0, i)
                                .map(j -> triangle.get(i).get(j) + Math.min(dp.get(j), dp.get(j + 1)))
                                .boxed()
                                .collect(Collectors.toList()),
                        (a, b) -> a
                ).getFirst();
    }
}
