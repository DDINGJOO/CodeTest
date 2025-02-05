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
import java.util.function.Predicate;

public class Main{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static int n;
    static int result =0; 
    public static void main(String[] args) {
        solve1(args);
    }
    
    public static void solve1(String[] args)
    {
        try{
            n= Integer.parseInt(br.readLine());
            for(int i =0 ; i<n ; i++){
                String input = br.readLine();
                if(isGroupWordForSolve1(input)){
                    result++;
                }
            }
        }catch(IOException e)
        {System.out.println("IOException");}

        System.out.println(result);
    }


            
    public static void solve2(String[] args) {
        try {
            n = Integer.parseInt(br.readLine());

            Predicate<String> isGroupWord = (str) -> {
                HashSet<Character> hashSet = new HashSet<>();
                char prevChar = str.charAt(0);
                hashSet.add(prevChar);

                for (int i = 1; i < str.length(); i++) {
                    char currentChar = str.charAt(i);
                    if (currentChar != prevChar) {
                        if (hashSet.contains(currentChar)) {
                            return false;
                        }
                        hashSet.add(currentChar);
                    }
                    prevChar = currentChar;
                }
                return true;
            };
            for (int i = 0; i < n; i++) {
                if (isGroupWord.test(br.readLine())) {
                    result++;
                }
            }

            System.out.println(result);
        } catch (IOException e) {
            System.out.println("IOException occurred");
        }
    }
    public static boolean isGroupWordForSolve1(String str)
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
