import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] person_1 = {1, 2, 3, 4, 5};
        int[] person_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (person_1[i % person_1.length] == answers[i]) score[0]++;
            if (person_2[i % person_2.length] == answers[i]) score[1]++;
            if (person_3[i % person_3.length] == answers[i]) score[2]++;
        }


        int maxScore = Arrays.stream(score).max().getAsInt();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == maxScore) answer.add(i + 1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
