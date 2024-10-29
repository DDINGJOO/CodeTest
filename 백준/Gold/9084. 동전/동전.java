/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9084                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9084                           #+#        #+#      #+#    */
/*   Solved: 2024/10/29 11:21:14 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    // N원을 a,b,c원의 동전으로 표기할 수 있는 모든 경우의 수 
    // 최소단위,,?   1 0 0, 0 1 0, 0 0 1, 1 1 0, 0 1 1, 1 0 1, 1 1 1 -> if 2 1 0 ? 1 1 0 + 1 0 0  
    //              100원 -> 10 * 10 , 50 *2 , 50 *1  10*5
    //                    -> 50 0 10*10 
    //                    -> 50 1 -> 50원을 만들기 -> 50 o
    //                                            -> 50 x

    // Solved by Dp Algorith
    public static void main(String[] arg) throws IOException
    {
        int t = sc.nextInt();


        for(int T =0; T<t ; T++)
        {
            int N = sc.nextInt();
            int[]coins = new int[N];
            for(int i =0; i<N ; i++)
            {
                coins[i] = sc.nextInt();
            }

            int M = sc.nextInt();
            int[] dp = new int[M+1];
            dp[0] = 1;


            for(int i =0; i<N; i++)
            {
                for(int j =1; j<=M; j++)
                {
                    if(j>=coins[i])
                    {
                        dp[j] +=dp[j-coins[i]];
                    }
                }
            }

            sb.append(dp[M]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}