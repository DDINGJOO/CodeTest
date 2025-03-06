/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2263                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2263                           #+#        #+#      #+#    */
/*   Solved: 2025/03/06 08:55:23 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] inOrder;
    static int[] postOrder;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        n = Integer.parseInt(br.readLine());
        inOrder = new int[100001];
        postOrder = new int[100001];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(stk.nextToken());
        }

        printPreOrder(0, n-1, 0, n-1);

        bw.flush();
        bw.close();
    }
    static void printPreOrder(int inLeft, int inRight, int postLeft, int postRight) throws  IOException {
        if(inLeft > inRight || postLeft > postRight)
            return;
        int root = postOrder[postRight];
        int rootIdx = 0;
        for(int i = inLeft; i<=inRight; i++){
            if(inOrder[i] == root){
                rootIdx = i;
            }
        }
        bw.write(inOrder[rootIdx]+" ");

        int leftSubtreeSize = rootIdx - inLeft;

        printPreOrder(inLeft, rootIdx - 1, postLeft, postLeft + leftSubtreeSize - 1);
        printPreOrder(rootIdx + 1, inRight, postLeft + leftSubtreeSize, postRight - 1);
    }


}