import java.util.*;

class Solution {
    public int solution(String dirs) {
        char[] commands = dirs.toCharArray();
        
        int[][][] demantion = new int[11][11][4];
        
        int x = 5;
        int y = 5;
        int answer = 0;
        
        
        // L R U D  -> 0 1 2 3 
        
        
        for( char ch : commands)
        {
            
            if( ch == 'L')
            {
                if(outOfRange((x-1), y))
                {
                    if(demantion[y][x-1][1] == 0)
                    {
                        //간적이 없을때
                        answer +=1;    
                    }
                    demantion[y][x][0] =1;
                    demantion[y][x-1][1] =1;
                    x-=1;
                }
            }
            
            if( ch == 'R')
            {
                if(outOfRange(x+1,y))
                {
                    if(demantion[y][x+1][0] ==0)
                    {
                        answer +=1;
                    }
                    demantion[y][x][1] =1;
                    demantion[y][x+1][0] = 1;
                    x+=1;
                }
            }
            
            if(ch == 'U')
            {
                if(outOfRange(x,y+1))
                {
                    if(demantion[y+1][x][3] ==0)
                    {
                        answer +=1;
                    }
                    demantion[y][x][2] =1;
                    demantion[y+1][x][3] =1;
                    y+=1;
                }
            }
            
            if(ch == 'D')
            {
                if(outOfRange(x,y-1))
                {
                    if(demantion[y-1][x][2] ==0)
                    {
                        answer +=1;
                    }
                    demantion[y][x][3] =1;
                    demantion[y-1][x][2] =1;
                    y-=1;
                }
            }
        System.out.println(ch);
            System.out.println(answer);
            System.out.println(x+","+y);
        }
        
        
        
        return answer;
    }
    
    
    public boolean outOfRange(int x, int y)
    {
        if(x<0 || x>10 || y<0 || y>10)
        {
            return false;
        }
        return true;
    }
}


