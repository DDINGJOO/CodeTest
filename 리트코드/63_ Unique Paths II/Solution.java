class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        int[][] pathCount = new int[rows][cols];
        
        if (isBlocked(0, 0, obstacleGrid)) {
            return 0;
        }
        
        pathCount[0][0] = 1;
        
        for (int col = 1; col < cols; col++) {
            pathCount[0][col] = isBlocked(0, col, obstacleGrid)
                    ? 0
                    : pathCount[0][col - 1];
        }
        
        for (int row = 1; row < rows; row++) {
            pathCount[row][0] = isBlocked(row, 0, obstacleGrid)
                    ? 0
                    : pathCount[row - 1][0];
        }
        
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                pathCount[row][col] = isBlocked(row, col, obstacleGrid)
                        ? 0
                        : pathCount[row - 1][col] + pathCount[row][col - 1];
            }
        }
        
        return pathCount[rows - 1][cols - 1];
    }
    
    private boolean isBlocked(int row, int col, int[][] obstacleGrid) {
        return obstacleGrid[row][col] == 1;
    }
}
