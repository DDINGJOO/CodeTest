package 알고스팟;

import java.util.*;

public class BOARDCOVER {
    static final int[][][] coverType = {
            {{0,0},{1,0},{0,1}},
            {{0,0},{0,1},{1,1}},
            {{0,0},{1,0},{1,1}},
            {{0,0},{1,0},{1,-1}}
    };

    static int H, W;
    static int[][] board;

    static int countWhite() {
        int c = 0;
        for (int y = 0; y < H; y++)
            for (int x = 0; x < W; x++)
                if (board[y][x] == 0) c++;
        return c;
    }

    // delta=+1 놓기, delta=-1 되돌리기
    static boolean set(int y, int x, int type, int delta) {
        boolean ok = true;
        for (int i = 0; i < 3; i++) {
            int ny = y + coverType[type][i][1];
            int nx = x + coverType[type][i][0];
            if (ny < 0 || ny >= H || nx < 0 || nx >= W) ok = false;
            else {
                board[ny][nx] += delta;
                if (board[ny][nx] > 1) ok = false; // 막힌칸(1) 위에 놓거나 겹치면 2 이상
            }
        }
        return ok;
    }

    static int cover() {
        // 1) 가장 첫 빈칸 찾기
        int y = -1, x = -1;
        outer:
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (board[i][j] == 0) {
                    y = i; x = j;
                    break outer;
                }
            }
        }

        // 2) 더 이상 빈칸 없으면 1가지 완성
        if (y == -1) return 1;

        int ret = 0;
        // 3) 4가지 블록을 (y,x)에 놓아보기
        for (int type = 0; type < 4; type++) {
            if (set(y, x, type, +1)) {
                ret += cover();
            }
            // ★ 중요: 무조건 원복
            set(y, x, type, -1);
        }
        return ret;
    }

    public static void main(String[] args) {
        // 예시 입력 처리 (원래 문제 입력 방식에 맞게 바꾸면 됨)
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            H = sc.nextInt();
            W = sc.nextInt();
            board = new int[H][W];
            for (int i = 0; i < H; i++) {
                String line = sc.next();
                for (int j = 0; j < W; j++) {
                    board[i][j] = (line.charAt(j) == '#') ? 1 : 0;
                }
            }

            // 흰칸이 3의 배수가 아니면 애초에 0
            if (countWhite() % 3 != 0) {
                System.out.println(0);
            } else {
                System.out.println(cover());
            }
        }
    }
}