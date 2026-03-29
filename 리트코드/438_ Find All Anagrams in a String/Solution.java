import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


/*
    과도한 객체지향과 함수형 프로그래밍 연습도 겸사겸사.. 한거라.. 억지스러운 부분들이 있는거 알아욤...
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return List.of();
        }

        return IntStream.range(0, s.length())
                .collect(
                        () -> SlidingAnagramCollector.from(s, p),
                        SlidingAnagramCollector::accumulate,
                        SlidingAnagramCollector::combine
                )
                .startIndexes();
    }

    private static final class SlidingAnagramCollector {
        private static final int ALPHABET_SIZE = 26;

        private final String text;
        private final int[] neededByLetter;
        private final int windowLength;
        private final List<Integer> startIndexes;
        private int missingLetterCount;
        private int windowLeft;

        private SlidingAnagramCollector(String text, String pattern) {
            this.text = text;
            this.neededByLetter = new int[ALPHABET_SIZE];
            this.windowLength = pattern.length();
            this.startIndexes = new ArrayList<>();
            this.missingLetterCount = pattern.length();
            pattern.chars().forEach(this::addNeededLetter);
        }

        private static SlidingAnagramCollector from(String text, String pattern) {
            return new SlidingAnagramCollector(text, pattern);
        }

        private void accumulate(int windowRight) {
            include(text.charAt(windowRight));
            shrinkWindowIfNeeded(windowRight);
            if (isAnagramWindow(windowRight)) {
                startIndexes.add(startIndexAt(windowRight));
            }
        }

        private int startIndexAt(int windowRight) {
            return windowRight - windowLength + 1;
        }

        private List<Integer> startIndexes() {
            return startIndexes;
        }

        private void addNeededLetter(int letter) {
            neededByLetter[toLetterIndex(letter)]++;
        }

        private void include(char letter) {
            int letterIndex = toLetterIndex(letter);
            if (neededByLetter[letterIndex] > 0) {
                missingLetterCount--;
            }
            neededByLetter[letterIndex]--;
        }

        private void shrinkWindowIfNeeded(int windowRight) {
            if (currentWindowLength(windowRight) > windowLength) {
                exclude(text.charAt(windowLeft));
                windowLeft++;
            }
        }

        private void exclude(char letter) {
            int letterIndex = toLetterIndex(letter);
            if (neededByLetter[letterIndex] >= 0) {
                missingLetterCount++;
            }
            neededByLetter[letterIndex]++;
        }

        private boolean isAnagramWindow(int windowRight) {
            return missingLetterCount == 0 && currentWindowLength(windowRight) == windowLength;
        }

        private void combine(SlidingAnagramCollector ignored) {
            throw new UnsupportedOperationException("지원하지 않습니다.(그냥 만들어 봤음요)");
        }

        private int currentWindowLength(int windowRight) {
            return windowRight - windowLeft + 1;
        }

        private int toLetterIndex(int letter) {
            return letter - 'a';
        }
    }
}
