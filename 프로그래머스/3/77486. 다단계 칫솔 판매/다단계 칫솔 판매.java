import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
      HashMap<String, String> TreeByMap = new HashMap<>();
        
        for( int i= 0 ; i<enroll.length ; i++)
        {
            TreeByMap.put(enroll[i], referral[i]);
        }
        
        
        
        
        
        HashMap<String, Integer> total  = new HashMap<>();
        
        
        for( int i =0 ; i<seller.length; i++)
        {
            String cntName = seller[i];
            int money = amount[i] * 100;
            
            while(money > 0 && !cntName.equals("-"))
            {
                total.put(cntName, total.getOrDefault(cntName, 0 ) + money - (money/10));
                cntName = TreeByMap.get(cntName);
                money/=10;
            }
        }
        
        
        
        
        int[] sol = new int[enroll.length];
        for(int i=0 ; i<enroll.length; i++)
        {
            sol[i] = total.getOrDefault(enroll[i],0);
        }
        
        return sol;
    }
}