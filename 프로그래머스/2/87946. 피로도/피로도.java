import java.util.*;
import java.math.*;

class Solution {
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, visited,dungeons, 0);
        return answer;
    }
    
    public void dfs ( int k, boolean[] visit, int[][] dungeons,int count)
    {
        answer = Math.max(answer, count);
        
        for(int i =0 ; i< dungeons.length; i++)
        {
            if(visit[i]) continue;  // 이미 방문
            if(k < dungeons[i][0]) continue;
            
            visit[i] = true;
            dfs(k-dungeons[i][1], visit, dungeons, count+1);
            visit[i] = false;
        }
    }
    
}


