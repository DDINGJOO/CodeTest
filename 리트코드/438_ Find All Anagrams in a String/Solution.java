import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        AnagramFinder anagramFinder = new AnagramFinder(s, p);
        return anagramFinder.findAllStartIndexes();
    }

    private static final class AnagramFinder {
        private static final int ALPHABET_SIZE = 26;

        private final String sourceText;
        private final int[] remainingLetters;
        private final int patternLength;
        private int remainingMatchCount;
        private int windowStart;

        private AnagramFinder(String sourceText, String pattern) {
            this.sourceText = sourceText;
            this.remainingLetters = new int[ALPHABET_SIZE];
            this.patternLength = pattern.length();
            this.remainingMatchCount = pattern.length();
            initializePatternFrequency(pattern);
        }

        private List<Integer> findAllStartIndexes() {
            List<Integer> startIndexes = new ArrayList<>();
            if (patternLength > sourceText.length()) {
                return startIndexes;
            }

            for (int windowEnd = 0; windowEnd < sourceText.length(); windowEnd++) {
                include(sourceText.charAt(windowEnd));

                if (windowSize(windowEnd) > patternLength) {
                    exclude(sourceText.charAt(windowStart));
                    windowStart++;
                }

                if (isPerfectAnagramWindow(windowEnd)) {
                    startIndexes.add(windowStart);
                }
            }

            return startIndexes;
        }

        private void initializePatternFrequency(String pattern) {
            for (int index = 0; index < pattern.length(); index++) {
                remainingLetters[toAlphabetIndex(pattern.charAt(index))]++;
            }
        }

        private void include(char letter) {
            int alphabetIndex = toAlphabetIndex(letter);
            if (remainingLetters[alphabetIndex] > 0) {
                remainingMatchCount--;
            }
            remainingLetters[alphabetIndex]--;
        }

        private void exclude(char letter) {
            int alphabetIndex = toAlphabetIndex(letter);
            if (remainingLetters[alphabetIndex] >= 0) {
                remainingMatchCount++;
            }
            remainingLetters[alphabetIndex]++;
        }

        private boolean isPerfectAnagramWindow(int windowEnd) {
            return remainingMatchCount == 0 && windowSize(windowEnd) == patternLength;
        }

        private int windowSize(int windowEnd) {
            return windowEnd - windowStart + 1;
        }

        private int toAlphabetIndex(char letter) {
            return letter - 'a';
        }
    }
}
