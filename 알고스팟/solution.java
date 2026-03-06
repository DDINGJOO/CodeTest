package 알고스팟;

  class Solution {
      private static final int INF = 1_000_000_000;

      private final int[][] mapper = {
          {0, 1, 2},
          {3, 7, 9, 11},
          {4, 10, 14, 15},
          {0, 4, 5, 6, 7},
          {6, 7, 8, 10, 12},
          {0, 2, 14, 15},
          {3, 14, 15},
          {4, 5, 7, 14, 15},
          {1, 2, 3, 4, 5},
          {3, 4, 5, 9, 13}
      };

      public int solution(int[] clocks) {
          int[] state = clocks.clone();

          // 3,6,9,12 -> 1,2,3,0
          for (int i = 0; i < state.length; i++) {
              state[i] = (state[i] % 12) / 3;
          }

          int ans = dfs(0, state);
          return ans >= INF ? -1 : ans;
      }

      // switch idx부터 끝까지 최소 횟수
      private int dfs(int idx, int[] clocks) {
          if (idx == 10) {
              return isSolved(clocks) ? 0 : INF;
          }

          int ret = INF;
          // 현재 스위치를 0~3번 누르는 경우 시도
          for (int cnt = 0; cnt < 4; cnt++) {
              ret = Math.min(ret, cnt + dfs(idx + 1, clocks));
              push(idx, clocks); // 다음 cnt 케이스를 위해 1번 더 누름
          }
          // 4번 누르면 원상복구되므로 별도 undo 필요 없음
          return ret;
      }

      private void push(int switchNo, int[] clocks) {
          for (int c : mapper[switchNo]) {
              clocks[c] = (clocks[c] + 1) % 4;
          }
      }

      private boolean isSolved(int[] clocks) {
          for (int c : clocks) {
              if (c != 0) return false;
          }
          return true;
      }
  }