class Solution {
    static int count =0;
    static int call =0;
    public int[] solution(String s) {

        /*
            input ; String
                1. s 의 모든 '0'을 제거
                2. 지운후 문자열의 길이를 c라하면, c를 2진법으로 표현한 문자열

                2진 변환의 횟수와 변환과정에서 제거된 모든0의 갯수를 담아 return

        */



        changeBinary(s);

        int[] answer = new int[2];
        answer[0] = call;
        answer[1] = count;
        return answer;
    }

    public void changeBinary(String s)
    {
        System.out.println(s);
        call+=1;
        char[] char_arr = s.toCharArray();
        int len = 0;
        for( char i : char_arr)
        {
            if( i == '0')
            {
                count ++;
            }
            else
            {
                len++;
            }
        }

        String str1 = Integer.toString(len, 2);

        if(len == 1)
        {
            return;
        }
        else
        {
            changeBinary(str1);
        }
    }
}