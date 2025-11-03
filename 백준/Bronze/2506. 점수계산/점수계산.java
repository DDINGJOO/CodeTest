/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2506                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2506                           #+#        #+#      #+#    */
/*   Solved: 2025/11/03 13:43:52 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int qNum = sc.nextInt();
        int result = 0;
        int combo = 1;
        for(int i =0 ; i< qNum ; i++)
        {
            if(sc.nextInt() == 1)
            {
                result += combo;
                combo += 1; 
            }
            else{
                combo =1;
            }
        }

        System.out.print(result);
    }

}