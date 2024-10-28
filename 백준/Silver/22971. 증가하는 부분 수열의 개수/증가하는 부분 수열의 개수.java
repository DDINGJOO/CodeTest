/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 22971                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/22971                          #+#        #+#      #+#    */
/*   Solved: 2024/10/28 17:56:24 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();



    public static void main (String[] arg) throws IOException
    {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] nums = new int[N];
        int[] dp = new int[N];

        for(int i =0; i<N ;i++)
        {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0 ; i<N ; i++)
        {
            dp[i] = 1;
            for(int j =0; j<i; j++)
            {
                if(nums[i] > nums[j])
                dp[i] = (dp[i]+dp[j]) %998244353;
            }
        }

        for(int i : dp)
        {
            sb.append(i).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}