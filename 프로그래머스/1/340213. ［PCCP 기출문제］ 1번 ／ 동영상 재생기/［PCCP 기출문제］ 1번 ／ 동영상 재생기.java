import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = TimeToInt(video_len);
        int cnt = TimeToInt(pos);
        int start = TimeToInt(op_start);
        int end = TimeToInt(op_end);
        if(op_check(start,end,cnt) == true)
        {
            cnt = end;
        }

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("next")) {
                if (cnt + 10 >= len) {
                    cnt = len;
                } 
                else 
                {
                    cnt += 10;
                }
            } 
            
            else if (commands[i].equals("prev")) {
                if (cnt - 10 <= 0)
                {
                    cnt = 0;
                    
                }
                else
                {
                    cnt -= 10;
                }    
            }
            if (op_check(start, end, cnt))
            {
                        cnt = end;
                    }
        }

        return formatTime(cnt);
    }

    
    public int TimeToInt(String time) {
        String[] Time_arr = time.split(":");
        int mtime = Integer.parseInt(Time_arr[0]) * 60;
        mtime += Integer.parseInt(Time_arr[1]);
        return mtime;
    }

    
    public String formatTime(int time) {
        int mm = time / 60;
        int ss = time % 60;
        return String.format("%02d:%02d", mm, ss);
    }

    
    public boolean op_check(int start, int end, int cnt) {
        return start <= cnt && cnt <= end;
    }
}
