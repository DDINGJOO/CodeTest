/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1535                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1535                           #+#        #+#      #+#    */
/*   Solved: 2024/10/30 08:52:47 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */


import java.io.*;
import java.util.*;




public class Main{

    static Scanner sc = new Scanner(System.in);


    //N 명, N<=20m
    /*
     *  1~N 까지 채력 잃는 수 
     *  1~N  까지 얻는 기쁨
     * 
     * 
     *  배낭 문제 ->
     *      
     * 
     */
    public static void main(String[] arg)throws IOException
    {
        int N = sc.nextInt();
        int K = 100;

        
        int[][] item = new int[N+1][2];

        for(int i=1; i<=N ; i++)
        {
            item[i][0] =  sc.nextInt();
        }
        for(int i= 1 ; i<=N ; i++)
        {
            item[i][1] =  sc.nextInt();
        }



        int[][]dp = new int[N+1][K+1];


        for (int k = 1; k <= K; k++) { // 무게
            for (int i = 1; i <= N; i++) { // item
                dp[i][k] = dp[i - 1][k];
                if (k - item[i][0] > 0) {
                    dp[i][k] = Math.max(dp[i - 1][k], item[i][1] + dp[i - 1][k - item[i][0]]);
                }
            }
        }


        System.out.println(dp[N][K]);
    }
}