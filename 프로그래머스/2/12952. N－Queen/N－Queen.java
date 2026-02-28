import java.util.*;

class Solution {
    private int n;
    private int count;
    private boolean[] col;    // col[c] = true면  이미 퀸 재
    private boolean[] diag1;  // diag1[r - c + (n-1)] :  대각선 (r-c 일정)
    private boolean[] diag2;  // diag2[r + c]         :  대각선 (r+c 일정)

    public int solution(int n) {
        this.n = n;
        this.count = 0;

        col = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];

        dfs(0);
        return count;
    }

    private void dfs(int r) {
        
        if (r == n) {
            count++;
            return;
        }

        // try
        for (int c = 0; c < n; c++) {
            int d1 = r - c + (n - 1);
            int d2 = r + c;

            if (col[c] || diag1[d1] || diag2[d2]) continue;

            // put
            col[c] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            dfs(r + 1);

            //roll back
            col[c] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}