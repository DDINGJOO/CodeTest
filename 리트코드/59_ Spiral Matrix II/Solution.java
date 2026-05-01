class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        fillLayer(matrix, 0, n, 1);

        return matrix;
    }

    private int fillLayer(int[][] matrix, int start, int size, int value) {
        if (size == 0) {
            return value;
        }

        if (size == 1) {
            matrix[start][start] = value;
            return value + 1;
        }

        int end = start + size - 1;

        for (int col = start; col < end; col++) {
            matrix[start][col] = value++;
        }

        for (int row = start; row < end; row++) {
            matrix[row][end] = value++;
        }

        for (int col = end; col > start; col--) {
            matrix[end][col] = value++;
        }

        for (int row = end; row > start; row--) {
            matrix[row][start] = value++;
        }

        return fillLayer(matrix, start + 1, size - 2, value);
    }
}
