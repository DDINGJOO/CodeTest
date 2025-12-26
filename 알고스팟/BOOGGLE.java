package 알고스팟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



class BOOGGLE {
    public static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            char[][] board = new char[5][5];
            for (int i = 0; i < 5; i++) {
                String line = fs.next();
                board[i] = line.toCharArray();
            }
            
            int W = fs.nextInt();
            List<String> words = new ArrayList<>();
            for (int i = 0; i < W; i++) {
                words.add(fs.next());
            }
            for (String w : words) {
                sb.append(w).append(' ')
                        .append(solution(w.toCharArray(), board) ? "YES" : "NO")
                        .append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    static class Point{
        int x ,y;
        Point(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    public static boolean solution(char[] word, char[][] board){
        for(int y = 0; y < 5; y++) {
            for(int x = 0; x < 5; x++) {
                if(board[y][x] == word[0]) {
                    if(findNext(word, board, new Point(x, y), 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean findNext(char[] word, char[][] board, Point point, int index) {
        if (board[point.y][point.x] != word[index]) return false;
        if (index == word.length - 1) return true;
        
        // 8방향으로 다음 글자 탐색
        for (int dir = 0; dir < 8; dir++) {
            int nx = point.x + dx[dir];
            int ny = point.y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            if (findNext(word, board, new Point(nx, ny), index + 1)) {
                return true;
            }
        }
        return false;
    }

    private static class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;
        
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
