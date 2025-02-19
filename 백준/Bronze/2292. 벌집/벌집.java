/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2292                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2292                           #+#        #+#      #+#    */
/*   Solved: 2025/02/20 01:16:53 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)  throws  IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long i = 1;
        while(true)
        {
            if(n <= cal(i) )
            {
                System.out.println(i);
                return;
            }
            i++;
        }
    }

    public static long cal (long n)
    {
        return 1+3*n*(n-1);
    }
}