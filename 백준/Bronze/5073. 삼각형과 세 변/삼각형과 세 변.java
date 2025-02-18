/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 5073                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/5073                           #+#        #+#      #+#    */
/*   Solved: 2025/02/18 13:58:56 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        while(true)
        {
            int lo = Math.max(a,b);
            lo = Math.max(lo,c);
            if(lo*2 >= a+b+c)
            {
               sb.append("Invalid");
            }

            else if(a == b && b==c)
            {
                sb.append("Equilateral");
            }

            else if(a==b || b==c|| c==a)
            {
                sb.append("Isosceles");
            }
            else
            {
                sb.append("Scalene");
            }

            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            if(a!=0 || b!=0 || c!=0)
            {
                sb.append("\n");
            }
            else
            {
                break;
            }
        }
        sc.close();
        System.out.println(sb.toString());
    }
}