/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1316                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1316                           #+#        #+#      #+#    */
/*   Solved: 2025/02/05 13:04:19 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int n;
    static int result =0; 
    
    public static void main (String[] args)
    {
        try{
            n= Integer.parseInt(br.readLine());
            for(int i =0 ; i<n ; i++){
                String input = br.readLine();
                if(isGroupWord(input) == true){
                    result++;
                }
            }
        }catch(IOException e)
        {System.out.println("IOException");}

        System.out.println(result);
    }
            
    

    public static boolean isGroupWord(String str)
    {
        HashSet<Character> hashSet = new HashSet<>(); 
        char prevChar = str.charAt(0);
        hashSet.add(prevChar);


        for(char currentChar : str.toCharArray())
        {
            if(currentChar != prevChar)
            {
                if(hashSet.contains(currentChar))
                {
                    return false;
                }
                hashSet.add(currentChar);
            
            }
            prevChar = currentChar;
        
        }
        return true;
    }



}