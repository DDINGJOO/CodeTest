import java.util.*;


class Solution {
    static int[] result = new int[2];
    
    public int[] solution(int[][] arr) {
        test(arr,0,0,arr.length);
        return result;
        
    }
    //[[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]] <- testCase
    public void test(int[][]arr,int x, int y ,int size)
    {
        for(int i=x; i<x+size;i++)
        {
            for(int j =y; j<y+size ; j++)
            {
                if(arr[x][y] != arr[i][j])
                {
                    int offset = size/2;
                    test(arr, x,y, offset);
                    test(arr, x+offset,y,offset);
                    test(arr, x+offset, y+offset,offset);
                    test(arr, x, y+offset, offset);
                    return;
                }
            }
        }
        result[arr[x][y]]++;

            
    }
}
