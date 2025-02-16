import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
                .mapToInt(command -> {
                    int from = command[0] - 1;
                    int to = command[1];
                    int k = command[2] - 1;
                    
                    return Arrays.stream(Arrays.copyOfRange(array, from, to))
                                 .sorted()
                                 .toArray()[k];
                })
                .toArray();
    }
}
