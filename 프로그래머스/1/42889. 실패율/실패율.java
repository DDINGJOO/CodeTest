import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        Map<Integer, Double> failureRateMap = new HashMap<>();


        int[] stageCount = new int[N + 2];
        for (int stage : stages) {
            stageCount[stage]++;
        }
        int totalPlayers = stages.length;


        for (int i = 1; i <= N; i++) {
            if (totalPlayers == 0) {
                failureRateMap.put(i, 0.0); // 실패율 0
            } else {
                failureRateMap.put(i, (double) stageCount[i] / totalPlayers);
                totalPlayers -= stageCount[i];
            }
        }

       
        List<Integer> sortedStages = new ArrayList<>(failureRateMap.keySet());
        sortedStages.sort((a, b) -> {
            int compare = Double.compare(failureRateMap.get(b), failureRateMap.get(a));
            return compare == 0 ? Integer.compare(a, b) : compare;
        });

     
        return sortedStages.stream().mapToInt(i -> i).toArray();
    }
}
