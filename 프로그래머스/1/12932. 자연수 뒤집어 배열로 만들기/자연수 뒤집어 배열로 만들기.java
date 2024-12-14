import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(long n) {
        int[] result= new int[13];
        int count = 0;

        while(true)
        {
            if(n/10 == 0 )
            {
                result[count++] = (int) (n%10);
                break;
            }

            result[count++] = (int)(n%10);
            n/=10;
        }





        int[] answer = new int[count];
        for(int i=0; i <count; i++)
        {
            answer[i] = result[i];

        }
        return answer;
    }
}

