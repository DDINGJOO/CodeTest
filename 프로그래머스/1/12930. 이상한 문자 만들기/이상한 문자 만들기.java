class Solution {
    public String solution(String s) {
        char[] arr_char = s.toLowerCase().toCharArray();
        int index = 1;
        StringBuilder sb = new StringBuilder();
        for( char i : arr_char)
        {
            if(i == ' ')
            {
                index = 1;
                sb.append(i);
                continue;
            }
            
            
            char temp = (index%2 == 0) ? i : Character.toUpperCase(i);
            sb.append(temp);
            index++;
            
        }
        String answer = sb.toString();
        return answer;
    }
}