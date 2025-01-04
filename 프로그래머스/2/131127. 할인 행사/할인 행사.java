import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        Deque<String> tmp = new ArrayDeque<>();
        int total =0,answer =0;
        
        for(int i=0; i<number.length; i++)
        {
            hashMap.put(want[i], number[i]);
        }
        
        
        
        
        
        
        for(String str : discount)
        {
            if(tmp.size() < 10)
            {
                tmp.addLast(str);
                if(hashMap.get(str) != null)
                {
                    
                    hashMap.replace(str,hashMap.get(str) -1);
                    if(hashMap.get(str) > -1)
                    {
                    total +=1;
                    }
                }
            }
            
            
            
            else
            {
                String before = tmp.pollFirst();
                tmp.addLast(str);
                //옛날거 삭제
                if(hashMap.get(before) != null) //target에 있고, value != 0
                {
                    hashMap.replace(before,hashMap.get(before) +1);
                    if(hashMap.get(before) > 0)
                    {
                    total -=1;
                    }
                }
                
                // 다음 날짜 넣기
                if(hashMap.get(str) != null)
                {
                    hashMap.replace(str,hashMap.get(str) -1);
                    if(hashMap.get(str) > -1)
                    {
                    total +=1;
                    }
                }
            }
            
            
            
            if(total == 10)
            {
                answer +=1;
            }
        }
        
        return answer;
        
    }
}