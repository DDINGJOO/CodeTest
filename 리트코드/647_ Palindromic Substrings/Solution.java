class Solution {
    public int countSubstrings(String s) {
        PalindromeCounter palindromeCounter = new PalindromeCounter(s);
        return palindromeCounter.countAll();
    }

    private static final class PalindromeCounter {
        private final String text;
        private final int length;

        private PalindromeCounter(String text) {
            this.text = text;
            this.length = text.length();
        }

        private int countAll() {
            int palindromeCount = 0;

            for (int center = 0; center < length; center++) {
                palindromeCount += countFromCenter(center, center);
                palindromeCount += countFromCenter(center, center + 1);
            }

            return palindromeCount;
        }

        private int countFromCenter(int leftIndex, int rightIndex) {
            int palindromeCount = 0;

            while (canExpand(leftIndex, rightIndex)) {
                palindromeCount++;
                leftIndex--;
                rightIndex++;
            }

            return palindromeCount;
        }

        private boolean canExpand(int leftIndex, int rightIndex) {
            return isInside(leftIndex) && isInside(rightIndex)
                    && text.charAt(leftIndex) == text.charAt(rightIndex);
        }

        private boolean isInside(int index) {
            return index >= 0 && index < length;
        }
    }
}
