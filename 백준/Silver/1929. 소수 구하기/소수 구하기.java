/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1929                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1929                           #+#        #+#      #+#    */
/*   Solved: 2025/08/04 13:37:01 by soh1001       ###          ###   ##.kr    */
/*                                ß                                            */
/* ************************************************************************** */

import java.util.Scanner;

class Main{
   
    public static boolean[] prime;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {

        int M = sc.nextInt();
        int N = sc.nextInt();

        make_prime(N);
        for(int i = M ; i<=N ; i++)
        {
            if(prime[i] ==  false)
            {
                System.out.println(i);
            }
        }
    }



	// N 이하 소수 생성 
	public static void make_prime(int N) {
		
		prime = new boolean[N + 1];	
 
		/*
		소수 ->  false 
        소수 아님 -> true
		*/

		if(N < 2) {
			return;
		}
        
		prime[0] = prime[1] = true;
		
        
		for(int i = 2; i <= Math.sqrt(N); i++) {
        
			
			if(prime[i] == true) {
				continue;
			}
        
			for(int j = i * i; j < prime.length; j = j+i) {
				prime[j] = true;
			}
		}
 
	}
 
}
            