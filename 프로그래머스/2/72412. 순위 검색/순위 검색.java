import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        

        for(String s : info) {
            String[] parts = s.split(" ");
            int score = Integer.parseInt(parts[4]);
            String[] conditions = {parts[0], parts[1], parts[2], parts[3]};
            dfs(conditions, 0, "", score, map);
        }
        

        for(ArrayList<Integer> list : map.values()) {
            Collections.sort(list);
        }
        
        int[] answer = new int[query.length];
        int idx = 0;
        

        for(String q : query) {
            q = q.replaceAll(" and", "");
            String[] qParts = q.split(" ");
            String key = qParts[0] + qParts[1] + qParts[2] + qParts[3];
            int targetScore = Integer.parseInt(qParts[4]);
            
            if(map.containsKey(key)) {
                ArrayList<Integer> scores = map.get(key);
                int count = binarySearch(scores, targetScore);
                answer[idx++] = count;
            } else {
                answer[idx++] = 0;
            }
        }
        
        return answer;
    }
    

    private void dfs(String[] conditions, int depth, String key, int score, HashMap<String, ArrayList<Integer>> map) {
        if(depth == conditions.length) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }

        dfs(conditions, depth + 1, key + conditions[depth], score, map);

        dfs(conditions, depth + 1, key + "-", score, map);
    }
    

    private int binarySearch(ArrayList<Integer> scores, int targetScore) {
        int low = 0;
        int high = scores.size();
        while(low < high) {
            int mid = (low + high) / 2;
            if(scores.get(mid) < targetScore) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return scores.size() - low;
    }
}
