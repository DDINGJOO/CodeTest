import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(String str : completion)
        {
            hashMap.put(str, hashMap.getOrDefault(str,0) +1);
        }
        
        for(String str : participant )
        {
            if(hashMap.getOrDefault(str,0) == 0)
            {
                return str;
            }
        
        
        
            hashMap.put(str,hashMap.get(str)-1);
        }
        
        
        return null;
    }   
}