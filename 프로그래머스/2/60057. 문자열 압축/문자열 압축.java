import java.util.*;


class Solution {
    private List<String> split(String s, int length)
    {
        List<String> L_tocken = new ArrayList<>();
        for(int i=0 ; i <s.length(); i+=length)
        {
            int j = i+length;
            if(j > s.length())
            {
                j = s.length();
            }
            L_tocken.add(s.substring(i,j));
        }
        return L_tocken;
    }
    
    private int min_leng(String s, int length)
    {
        StringBuilder sb = new StringBuilder();
        
        String last = "";
        int count =0;
        for(String tocken : split(s,length))
        {
            if(tocken.equals(last))
            {
                count++;
            }
            else
            {
                if(count >1 )
                {
                    sb.append(count);
                }
                sb.append(last);
                last = tocken;
                count = 1;
            }
        }
    
    
    if(count > 1)
    {
        sb.append(count);
    }
        sb.append(last);
        
        return sb.length();
}
    
    
    
    public int solution(String s) {
        /*
            aabbacc -> 2a2ba2c
            
            2개 이상 묶음도 처리가능 해야댐
            ababbd -> 2abbd
            
            ㅇㅋㅇㅋ
            
            -> 문자열을 다 잘랐을때 가장 작은 길이가되는 결과의 길이.
        
        */
        
        /*
            1. 문자열을 1개부터 자른다 -> 1234567 이렇게 있으면
            
                1 / 2/ 3/ 4/ 5/ 6/ 7
                    if -> 1 == 2 cnt++ -> 1==3? No -> 2(1)3 3부터 다시 시작..? 아니면 StringBuilder.append? o 
                    
                    abcde ab bc cd de 이문제는 어떻게 처리..?
        
        */
        
        int min = Integer.MAX_VALUE;
        for(int length =1 ;length <=s.length(); length++)
        {
            int comp = min_leng(s,length);
            if(comp < min)
            {
                min = comp;
            }
        }
        int answer = min;
        return answer;
    }

}