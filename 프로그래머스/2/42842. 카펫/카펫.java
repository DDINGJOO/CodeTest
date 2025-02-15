import java.util.*;

class Solution {
    static int[] result = new int[2];
    public int[] solution(int brown, int yellow) {
        
        // x,y -> (x-2)* (y-2) > yello
        // x*y - yello -> brown 
        // x,y ? 
        // brown + 4 = 2x + 2y 
        // yello = xy -2x-2y+4 
        // brown + yello = xy
        // x = (b + y)/y
        
        for(int y =1 ; y<2000000; y++)
        {
            double x = (double)(brown + yellow)/y;
            if(x != (int)x)
            {
                continue;
            }
            else
            {
                if(brown == 2*(x+y)-4)
                {
                    result[0] = (int)x;
                    result[1] = y;
                    break;
                }
            }
            
        }
        return result;
    }
    

}