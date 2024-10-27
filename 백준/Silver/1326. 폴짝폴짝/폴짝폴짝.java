
import java.io.*;
import java.math.BigInteger; // subtract , multiply, add, mod
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] arr;
    static int[] dp;
    static boolean[] v;

    public static void main(String[] args) throws IOException {

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[count];
        for(int i = 0 ; i<arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        dp = new int[10001];
        v = new boolean[10001];
        Arrays.fill(dp, 100_000);

        st = new StringTokenizer(br.readLine()," ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        bfs(s - 1, e - 1, count);
        if(dp[e-1] == 100_000)
            System.out.println(-1);
        else
            System.out.println(dp[e-1]);

    }
    public static void bfs(int s, int e, int count){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(s, 1));
        v[s] = true;

        while(!q.isEmpty()){
            Node numbers = q.poll();
            int mul = arr[numbers.idx]; // 배수
            int front = numbers.idx; // <-
            int back = numbers.idx; // ->


            // 뒤를 확인한다.
            while(true){
                back += mul;
                if(back >= count)
                    break;

                if(back == e) { // 찾았다.
                    dp[e] = numbers.jump;
                    return;
                }

                if(!v[back]) {
                    v[back] = true;
                    q.offer(new Node(back, numbers.jump + 1));
                }
            }


            // 앞을 확인한다.
            while(true){
                front -= mul;
                if(front < 0)
                    break;

                if(front == e) { // 찾았다.
                    dp[e] = numbers.jump;
                    return;
                }

                if(!v[front]) {
                    v[front] =true;
                    q.offer(new Node(front, numbers.jump + 1));
                }
            }
        }


    }
}
class Node{
    int idx;
    int jump;
    public Node(int idx, int jump){
        this.idx = idx;
        this.jump = jump;
    }
}