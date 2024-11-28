/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10798                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10798                          #+#        #+#      #+#    */
/*   Solved: 2024/11/28 18:07:18 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] cArr1 = sc.next().toCharArray();
		char[] cArr2 = sc.next().toCharArray();
		char[] cArr3 = sc.next().toCharArray();
		char[] cArr4 = sc.next().toCharArray();
		char[] cArr5 = sc.next().toCharArray();
		
		
		
		for(int i=0; i<15; i++) {
			if(cArr1.length > i) {
				bw.write(cArr1[i]);
			}
			if(cArr2.length > i) {
				bw.write(cArr2[i]);
			}
			if(cArr3.length > i) {
				bw.write(cArr3[i]);
			}
			if(cArr4.length > i) {
				bw.write(cArr4[i]);
			}
			if(cArr5.length > i) {
				bw.write(cArr5[i]);
			}
		}
		bw.flush();
		bw.close();
		
		sc.close();
	}

}
