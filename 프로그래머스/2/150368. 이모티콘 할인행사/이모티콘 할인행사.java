  import java.util.*;

  class Solution {
      int[] sale = {10, 20, 30, 40};

      public int[] solution(int[][] users, int[] emoticons) {
          int[] answer = {0, 0};
          int[] visit = new int[emoticons.length];
          for (int i = 0; i < emoticons.length; i++) {
              visit[i] = 0;
          }
          answer = dfs(users, emoticons, visit, answer,0);
          return answer;
      }

  public int[] dfs(int[][] users, int[] emoticons, int[] visit,
  int[] answer, int depth) {
      if (depth == emoticons.length) {
          int[] newAnswer = calculator(visit, emoticons, users);
          return maxAnswer(answer, newAnswer);
      }

      for (int percent : sale) {
          visit[depth] = percent;
          answer = dfs(users, emoticons, visit, answer, depth +
  1);
      }

      return answer;
  }

      public int[] calculator(int[] visits, int[] emoticons, int[][] users) {
          int[] answer = {0, 0};
          for (int[] user : users) {
              int temp = 0;
              for (int i = 0; i < visits.length; i++) {
                  if (visits[i] >= user[0]) {
                      temp += emoticons[i] * (100 -visits[i]) / 100;
                  }
              }
              if (temp >= user[1]) answer[0] += 1;
              else answer[1] += temp;
          }
          return answer;
      }

      public int[] maxAnswer(int[] answer, int[] newAnswer) {
          if (answer[0] > newAnswer[0]) {
              return answer;
          } else if (answer[0] == newAnswer[0]) {
              if (answer[1] > newAnswer[1]) {
                  return answer;
              } else {
                  return newAnswer;
              }
          } else {
              return newAnswer;
          }
      }
  }