import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> idToNicknameMap = new HashMap<>();
        int index = record.length;
        
        
        //Data Processing
        for(String str : record)
        {
            String[] myString = str.split(" ");
            if(myString[0].equals("Leave"))
            {
                continue;
            }
            else
            {
                if(myString[0].equals("Change")){ index-=1;}
                if(idToNicknameMap.get(myString[1]) == null)
                {
                    idToNicknameMap.put(myString[1], myString[2]);
                }
                else
                {
                    idToNicknameMap.replace(myString[1], myString[2]);
                }
            
            }
        }
        String[] strOut = new String[index];
                   int j = 0;
        //DataOutPut
        for(String i : record)
        {
            String[] str = i.split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(idToNicknameMap.get(str[1]));
            if(str[0].equals("Enter"))
            {
                sb.append("님이 들어왔습니다.");
            }
            else if(str[0].equals("Leave"))
            {
                sb.append("님이 나갔습니다.");
            }
            
            else
            {
                continue;
            }
            
            strOut[j] = sb.toString();
            j++;
        }
        
        return strOut;
    }
}