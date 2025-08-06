/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2437                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2437                           #+#        #+#      #+#    */
/*   Solved: 2025/08/06 10:54:56 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        br.readLine(); 

        int[] weights = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
 
        int measurableSum = 0; // 측정 가능한 누적 합
        for (int weight : weights) {
            if (weight > measurableSum + 1) {
                break;
            }
            measurableSum += weight;
        }
 
        bw.write((measurableSum + 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
 