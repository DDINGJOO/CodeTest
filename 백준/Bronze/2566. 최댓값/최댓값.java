/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2566                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2566                           #+#        #+#      #+#    */
/*   Solved: 2024/11/28 17:45:07 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.util.*;

public class Main{
    public static void main(String[] args) {
        {
            Scanner sc = new Scanner(System.in);
            int pos =0;
            int max = Integer.MIN_VALUE;

            for(int i =0 ; i< 81 ; i++)
            {
                int cnt = sc.nextInt();
                if(cnt >= max)
                {
                    pos = i;
                    max = cnt;
                }
            }


            int num1 = (pos/9) +1;
            int num2 = (pos%9) +1;

            StringBuilder sb = new StringBuilder();
            sb.append(max).append('\n').append(num1).append(' ').append(num2);
            System.out.print(sb.toString());
        }
    }
}