/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11723                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11723                          #+#        #+#      #+#    */
/*   Solved: 2025/02/19 00:12:41 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
            
        BitSet bitSet = new BitSet(21); 
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = 0;
            
            if (!command.equals("all") && !command.equals("empty")) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "add":
                    bitSet.set(x);
                    break;
                case "remove":
                    bitSet.clear(x);
                    break;
                case "check":
                    sb.append(bitSet.get(x) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    bitSet.flip(x);
                    break;
                case "all":
                    bitSet.set(1, 21); 
                    break;
                case "empty":
                    bitSet.clear();
                    break;
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
