
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstColZero = false;
        
        // 1차 패스: 마킹
        for (int i = 0; i < m; i++) {
            int[] row = matrix[i];
            
            if (row[0] == 0) {
                firstColZero = true;
            }
            
            for (int j = 1; j < n; j++) {
                if (row[j] == 0) {
                    row[0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // 2차 패스: 뒤에서부터 0 처리
        for (int i = m - 1; i >= 0; i--) {
            int[] row = matrix[i];
            
            for (int j = n - 1; j >= 1; j--) {
                if (row[0] == 0 || matrix[0][j] == 0) {
                    row[j] = 0;
                }
            }
            
            if (firstColZero) {
                row[0] = 0;
            }
        }
    }
}
