import java.util.*;

class Solution {
    static int[] w = {781, 156, 31, 6, 1}; 
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        
    public int solution(String word) {
        int result = 0;
        
        for (int i = 0; i < word.length(); i++) {
            int index = new String(vowels).indexOf(word.charAt(i)); 
            result += index * w[i] + 1; 
        }
        
        return result;
    }
}
