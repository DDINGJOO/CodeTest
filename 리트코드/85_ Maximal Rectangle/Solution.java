class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int cols = matrix[0].length;
        int[] heights = new int[cols + 1];
        int maxArea = 0;

        for (char[] row : matrix) {
            for (int col = 0; col < cols; col++) {
                heights[col] = row[col] == '1' ? heights[col] + 1 : 0;
            }

            int[] stack = new int[cols + 1];
            int top = -1;

            for (int col = 0; col <= cols; col++) {
                while (top >= 0 && heights[stack[top]] > heights[col]) {
                    int height = heights[stack[top--]];
                    int leftBoundary = top >= 0 ? stack[top] : -1;
                    int width = col - leftBoundary - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack[++top] = col;
            }
        }

        return maxArea;
    }
}
