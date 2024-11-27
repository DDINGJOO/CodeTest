class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        /*
            arr 1 -> a2*b3
            arr 2 -> c2*d3
            
            result -> c2*b3
        
            int[][]arr1 = new int[b][a]
            int[][]arr2 = new int[d][c]
            
            int[]][] answer = new int[b][c];
            b = height arr1.length;
            c = weidth arr2[0].length;
            
            for(int k = 0 ; k<)
        
        */
        
        int height = arr1.length;
        int width = arr2[0].length;
        int[][] result = new int[height][width];
        
        for(int k =0 ;k < width;k++)
        {
            for(int j=0 ; j<height; j++)
            {
                for(int i=0 ; i<arr1[0].length; i++)
                {
                    result[j][k] += arr1[j][i] * arr2[i][k];
                }
            }
        }
        
        return result;
    }
}