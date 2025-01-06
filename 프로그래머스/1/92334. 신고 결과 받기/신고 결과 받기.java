import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        HashMap<String, HashSet<String>> reports = new HashMap<>();
        HashMap<String, Integer> reportCount = new HashMap<>();


        for (String id : id_list) {
            reports.put(id, new HashSet<>());
            reportCount.put(id, 0);
        }


        for (String entry : report) {
            String[] parts = entry.split(" ");
            String reporter = parts[0];
            String reported = parts[1];


            if (reports.get(reporter).add(reported)) {
                reportCount.put(reported, reportCount.get(reported) + 1);
            }
        }


        HashMap<String, Integer> mailCount = new HashMap<>();
        for (String id : id_list) {
            mailCount.put(id, 0);
        }

        for (String id : id_list) {
            if (reportCount.get(id) >= k) {
                for (String reporter : id_list) {
                    if (reports.get(reporter).contains(id)) {
                        mailCount.put(reporter, mailCount.get(reporter) + 1);
                    }
                }
            }
        }


        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            result[i] = mailCount.get(id_list[i]);
        }

        return result;
    }
}
