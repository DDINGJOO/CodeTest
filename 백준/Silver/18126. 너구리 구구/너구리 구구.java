/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 18126                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: soh1001 <boj.kr/u/soh1001>                  +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/18126                          #+#        #+#      #+#    */
/*   Solved: 2025/08/07 19:44:09 by soh1001       ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.util.*;
import java.io.*;

class Main{
    static long result = 0;
    static List<List<Edge>> map;
    static boolean[] visited;

    static class Edge{
        int destination;
        int length;
        
        public Edge(int destination, int length){
            this.destination = destination;
            this.length = length;
        }

        @Override
        public String toString() {
            return "["+destination + ", " + length + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // List를 초기화합니다.
        map = new ArrayList<>();
        visited = new boolean[n + 1];

        // 0부터 n까지의 인덱스를 사용하기 위해 n+1개의 리스트를 추가합니다.
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine());
            
            int source = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

    
            map.get(source).add(new Edge(destination, length));
            map.get(destination).add(new Edge(source, length));
        }
        
        dfs(1, 0);

        System.out.println(result);
    }

    static void dfs(int cur, long distance){
        visited[cur] = true;
        result = Math.max(result, distance);

    
        map.get(cur).stream()
                .filter(edge -> !visited[edge.destination])
                .forEach(edge -> dfs(edge.destination, distance + edge.length));
    }
}
