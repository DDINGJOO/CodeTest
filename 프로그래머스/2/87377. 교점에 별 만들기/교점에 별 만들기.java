import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Point
        {
            long x;
            long y;
    
            public Point(long x, long y)
            {
                this.x = x;
                this.y = y;
            }
        }

class Solution {
    public String[] solution(int[][] line) {
        
        
        List<Point> points = new ArrayList<>();
        for(int i =0 ; i<line.length; i++)
        {
            for( int j =0 ; j<line.length ; j++)
            {
                double x = (double)((long)line[i][1]*(long)line[j][2] - (long)line[i][2]*(long)line[j][1]) / ((long)line[i][0]*(long)line[j][1] - (long)line[i][1]*(long)line[j][0]);
                double y = (double)((long)line[i][2]*(long)line[j][0] - (long)line[i][0]*(long)line[j][2]) /((long)line[i][0]*(long)line[j][1] - (long)line[i][1]*(long)line[j][0]);
                
                if(x % 1 ==0 && y%1 == 0)
                {
                    points.add(new Point((long)x,(long)y));
                }
        
            }
        }
        
        
        // min max
        long min_x = Long.MAX_VALUE;
        long min_y = Long.MAX_VALUE;
        long max_x = Long.MIN_VALUE;
        long max_y = Long.MIN_VALUE;
        
        for(Point p : points)
        {
            if(p.x < min_x)
            {
                min_x = p.x;
            }
            if(p.y < min_y)
            {
                min_y = p.y;
            }
            if(p.x > max_x)
            {
                max_x = p.x;
            }
            if(p.y > max_y)
            {
                max_y = p.y;
            }
        }
        
        
        int height = (int)(max_y - min_y +1);
        int weidth = (int)(max_x - min_x +1);
        
        
        
        
        
        char[][] canvers = new char[height][weidth];
        for(char[] row : canvers)
        {
            Arrays.fill(row,'.');
        }
        
        for(Point p : points)
        {
            int x = (int) p.x - (int)min_x;
            int y = (int) p.y - (int)min_y;
            canvers[y][x] = '*';
        }
        
    
        String[] answer = new String[canvers.length];
        for(int i=0 ; i<answer.length;i++)
        {
            answer[answer.length -i -1] = new String(canvers[i]);
        }
        return answer;
    
    
        
        
    }
}