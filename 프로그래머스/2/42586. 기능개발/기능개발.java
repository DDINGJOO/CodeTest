import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        
        /*
            100%가 되는 날짜 -> 뒤에서부터 Queue add
            poll -> if -> poll한 일자가 더 크면 -> continue
            아니면 int[i] -> count;
            
            반복.            
        */
        
         ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();


        for (int i = 0; i < speeds.length; i++) {
            int deadLine = (100 - progresses[i]) / speeds[i]; // 나머지는..?
            if ((100 - progresses[i]) % speeds[i] != 0) {
                deadLine += 1;
            }
            deque.addLast(deadLine);
        }

        int count = 1;
        int now = deque.pollFirst();
        if (deque.isEmpty()) {
            int[] array = new int[1];
            array[0] = now;
            return array;
        }

        while(!deque.isEmpty())
        {
            int k = deque.pollFirst();
            if(k>now)
            {
                answer.add(count);
                now = k;
                count=1;
            }
            else
            {
                count++;
            }
        }

        answer.add(count);


        int[] array = new int[answer.size()];
        int k =0;
        for(int j : answer)
        {
            array[k] = j;
            k++;
        }
        return array;
    
    
    
    }
}