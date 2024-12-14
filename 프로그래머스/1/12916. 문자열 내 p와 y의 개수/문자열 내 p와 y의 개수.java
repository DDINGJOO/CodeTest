class Solution {
    boolean solution(String s) {
        
        s = s.toUpperCase();
        int p_cnt = 0;
        int y_cnt = 0;
        
        
        char[] arr = s.toCharArray();
        for(char i : arr)
        {
            if(i == 'P')
            {
                p_cnt++;
            }
            else if( i == 'Y')
            {
                y_cnt++;
            }
                        
        }
        
        return(p_cnt == y_cnt);
    }
}