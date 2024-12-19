import java.util.*;

class Solution {
    boolean solution(String s) {
     
        int answer = 0;
        
        for(char i : s.toCharArray())
        {
            if(i == '(')
            {
                answer++;
            }
            else if(answer >0)
            {
                answer--;
            }
            else
            {
                return false;
            }
        }
        
        return (answer == 0);
            
        
    }
}
