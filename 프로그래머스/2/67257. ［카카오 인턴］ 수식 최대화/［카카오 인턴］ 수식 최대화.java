import java.util.*;
import java.util.function.LongBinaryOperator;

class Solution {
    private static final String[][] PRECEDENCE = {
        {"+", "-", "*"}, {"+", "*", "-"},
        {"-", "+", "*"}, {"-", "*", "+"},
        {"*", "+", "-"}, {"*", "-", "+"}
    };

    private static final Map<String, LongBinaryOperator> OPERATIONS = Map.of(
        "+", (a, b) -> a + b,
        "-", (a, b) -> a - b,
        "*", (a, b) -> a * b
    );

    private static long calculate(List<String> tokens, String[] precedence) {
        for (String op : precedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long left = Long.parseLong(tokens.get(i - 1));
                    long right = Long.parseLong(tokens.get(i + 1));
                    long result = OPERATIONS.get(op).applyAsLong(left, right);


                    tokens.subList(i - 1, i + 2).clear();
                    tokens.add(i - 1, String.valueOf(result));

                    i -= 2; 
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }

    public long solution(String expression) {
        List<String> tokens = new ArrayList<>
            (Arrays.asList(expression.split("(?<=[+*-])|(?=[+*-])")));

 
        return Arrays.stream(PRECEDENCE)
                .mapToLong(p -> Math.abs(calculate(new ArrayList<>(tokens), p)))
                .max()
                .orElse(0);
    }
}
