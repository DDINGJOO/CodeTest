import java.util.List;

class Solution {
    private static final String[] KEYPAD = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return List.of();
        }

        return digits.chars()
                .mapToObj(digit -> KEYPAD[digit - '0'])
                .reduce(List.of(""), this::appendLetters, this::merge);
    }

    private List<String> appendLetters(List<String> prefixes, String letters) {
        return prefixes.stream()
                .flatMap(prefix -> letters.chars()
                        .mapToObj(letter -> prefix + (char) letter))
                .toList();
    }

    private List<String> merge(List<String> left, List<String> right) {
        return java.util.stream.Stream.concat(left.stream(), right.stream()).toList();
    }
}
