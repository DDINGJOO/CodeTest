import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (str1, str2) -> {
            if(str1.charAt(n) != str2.charAt(n))
               {
                   return str1.charAt(n) - str2.charAt(n);
               }
              return str1.compareTo(str2);
              
                
        });
           
        return strings;
    }
}