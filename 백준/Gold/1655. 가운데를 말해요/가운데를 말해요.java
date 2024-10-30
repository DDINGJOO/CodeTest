/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1655                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1655                           #+#        #+#      #+#    */
/*   Solved: 2024/10/30 09:21:43 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */


import java.io.*;
import java.util.*;
public class Main{

    

    public static void main(String[] arg) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq1=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pq2=new PriorityQueue<>();
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<n;i++){

            //하나씩 교대로 넣기
            int num=Integer.parseInt(br.readLine());
            if(i%2==0) pq1.add(num);
            else pq2.add(num);

            // 넣다가 왼쪽이 오른쪽보다 크면
            if(!pq2.isEmpty()&&pq1.peek()>pq2.peek()){ 
                int t1=pq1.poll();
                int t2=pq2.poll();

                pq1.add(t2);
                pq2.add(t1);
            }
            sb.append(Integer.toString(pq1.peek())+"\n");
        }
        System.out.print(sb.toString());

    }

    /*
     * 
     *  시간제한 0.1초 -> 자료구조????
     *  
     * 우선순위 큐 
     * 
     *  오름차순 
     *  내림차순 
     *  띠긷끼ㄸㄱ 넣다가 각 탑을 비교했을때 오른차순의 탑이 더 크면 둘이 change
     * 
     */
}