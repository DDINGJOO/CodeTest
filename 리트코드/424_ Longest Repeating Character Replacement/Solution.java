import java.util.stream.IntStream;

class Solution {
    public int characterReplacement(String s, int k) {
        return IntStream.range(0, s.length())
                .collect(
                        () -> new ReplacementWindow(s, k),
                        ReplacementWindow::include,
                        ReplacementWindow::combine
                )
                .answer();
    }

    private static final class ReplacementWindow {
        private static final int ALPHABET_SIZE = 26;

        private final String text;
        private final int replacementLimit;
        private final int[] countByLetter;
        private int maxFrequency;
        private int left;
        private int answer;

        private ReplacementWindow(String text, int replacementLimit) {
            this.text = text;
            this.replacementLimit = replacementLimit;
            this.countByLetter = new int[ALPHABET_SIZE];
        }

        private void include(int right) {
            int rightIndex = toLetterIndex(text.charAt(right));
            countByLetter[rightIndex]++;
            maxFrequency = Math.max(maxFrequency, countByLetter[rightIndex]);

            shrinkUntilReplaceable(right);
            answer = Math.max(answer, currentWindowLength(right));
        }

        private void shrinkUntilReplaceable(int right) {
            while (requiredReplacementCount(right) > replacementLimit) {
                int leftIndex = toLetterIndex(text.charAt(left));
                countByLetter[leftIndex]--;
                left++;
            }
        }

        private int requiredReplacementCount(int right) {
            return currentWindowLength(right) - maxFrequency;
        }

        private int currentWindowLength(int right) {
            return right - left + 1;
        }

        private int answer() {
            return answer;
        }

        private void combine(ReplacementWindow ignored) {
            throw new UnsupportedOperationException("Sequential streams only.");
        }

        private int toLetterIndex(char letter) {
            return letter - 'A';
        }
    }
}
