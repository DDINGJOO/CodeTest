/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11050                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11050                          #+#        #+#      #+#    */
/*   Solved: 2024/10/31 13:57:18 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */


import java.util.*;

public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int k = sc.nextInt();
        int sol = fact(n)/(fact(n-k)*fact(k));


        System.out.println(sol);
    }


    public static int fact(int n)
    {
        int k=n;
        if(n <=0 )
        {
            return 1;
        }

        else
        {
            return  k *= fact(n-1);
        }
    }


}