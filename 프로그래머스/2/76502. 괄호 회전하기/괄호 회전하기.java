import java.util.*;
class Solution {
    public int solution(String s) {
        
//         0 1 2 3 4 5 6
        
//         [ { ( vs ) } ]
        
        
        int[] brackets = new int[s.length()];
        int i =0;
        for(char ch : s.toCharArray())
        {
            if(ch == '[')
            {
                brackets[i] = 0;
            }
            else if(ch == '{')
            {
                brackets[i] = 1;
            }
            else if(ch == '(')
            {
                brackets[i] = 2;
            }
            else if(ch == ']')
            {
                brackets[i] = 3;
            }
            else if(ch == '}')
            {
                brackets[i] = 4;
            }
            else if(ch == ')')
            {
                brackets[i] = 5;
            }
            
            i++;
        }
        
        
        int answer =0;
        for (int j =0 ; j< brackets.length; j++)
        {
            answer += checkCorrect(brackets , j);
        }
        return answer;
        
        
    }
    
    
    
    public int checkCorrect(int[] brackets ,int startIndex)
    {
        Stack<Integer> st = new Stack<>();
        int count =0;
        for(int i = startIndex; count != brackets.length;i++)
        {
            
            
            if(i == brackets.length)
            {
                i-= brackets.length;
            }
            
            
            
            if(brackets[i] < 3)
            {
                st.push(brackets[i]);
            }
            
            
            
            else if(st.isEmpty())
            {
                return 0;
            }
            
            
            else
            {
                if(st.peek() != (brackets[i]-3))
                {
                    return 0;
                }
                else
                {
                    st.pop();
                }
            }
            count++;
        }
        
        if(st.isEmpty()){return 1;}
        else{return 0;}
    }
}