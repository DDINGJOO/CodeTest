import java.util.*;
class Solution {
    public int[][] solution(int n) {
        List<int[]> count = new ArrayList<>();
        hanoi(n,1,3, count);
        return count.toArray(new int[0][]);
    }
    
    private void hanoi(int n , int from, int to, List<int[]> count){
        if(n== 1){
            count.add(new int[] { from , to});
            return;
        }
        
        int empty = 6- from - to;
        
        hanoi(n-1, from, empty,count);
        hanoi(1,from, to, count);
        hanoi(n-1,empty,to,count);
    }
        
}