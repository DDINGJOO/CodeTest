class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        
        int index_1 = 0;
        int index_2 =0;
        
        
        
        for(String str : goal)
        {
            if(index_1 < cards1.length)
            {
                if(str.equals(cards1[index_1])){ 
                    index_1+=1;
                    continue;
                }
            }
               
            if(index_2 < cards2.length)
            {
                if(str.equals(cards2[index_2])){ 
                    index_2+=1;
                    continue;
                }
            }
                return "No";
            
            
        }
        
        return"Yes";
    }
}