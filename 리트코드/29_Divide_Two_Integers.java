class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isPositive = hasSameSign(dividend, divisor);

        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        while (absDividend >= absDivisor) {
            long currentDivisor = absDivisor;
            int multiple = 1;

            while (absDividend >= (currentDivisor << 1)) {
                currentDivisor <<= 1;
                multiple <<= 1;
            }

            absDividend -= currentDivisor;
            quotient += multiple;
        }

        return isPositive ? quotient : -quotient;
    }

    private boolean hasSameSign(int dividend, int divisor) {
        return (dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0);
    }
}
