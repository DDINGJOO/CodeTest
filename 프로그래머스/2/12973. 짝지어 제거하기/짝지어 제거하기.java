import java.util.*;
class Solution
{
    public int solution(String s)
    {
  
        /*
        Given
        String : b a a b a a
        
        When
        
        for : 
            if : ~Stack.isEmpty()
            문자열 i != Stack.peek 
                Stack.push
            
            문자열 i == Stack.peek
                Stack.pop
            i+1
        
        Then 
        return : 
            문자열 모두 삭제 -> 1
            문자열 남아 있음 ->0
        
        */
        
        
        
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray())
        {
            if(st.isEmpty())
            {
                st.push(ch);
            }
            
            else//Not Empty
            {
                if(ch == st.peek()) // 처리후 이전 문자 == 내 문자
                {
                    st.pop();
                }
                else
                {
                    st.push(ch);
                }
            }
        }
        
        
        return st.size()==0 ? 1:0;
    
    }
}