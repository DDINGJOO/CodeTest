import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));
        for (String st : str) {
            sb.append(st);
        }
        
        //000000000
        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}
