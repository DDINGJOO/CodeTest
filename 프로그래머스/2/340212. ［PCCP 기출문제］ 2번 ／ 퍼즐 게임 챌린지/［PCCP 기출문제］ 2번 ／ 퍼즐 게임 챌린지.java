class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int level = 1;
        int step = 5;
        

        
        while(true)
        {
            
            long restTime = limit;
            for(int i = 0 ;i <diffs.length ; i++)
            {
                if(level >= diffs[i])
                {
                    restTime = success(times[i], restTime);
                }
                
                else
                {
                    if(i-1 < 0 )
                    {
                        restTime= failed(times[i], 0, diffs[i]-level, restTime);
                    }
                    else
                    {
                        restTime= failed(times[i], times[i-1], diffs[i]-level, restTime);
                    }
                }
                
                
                if(restTime <0)
                {
                    if(step > 0)
                    {
                        level+=step;
                        
                    }
                    else
                    {
                        return level+1;
                    }
                    break;
                }
                
            }
            if(restTime >= 0 )
            {
                if(level == 1)
                {
                    return 1;
                }
                if(step > 0 )
                {
                    step--;
                    level -= step;
                }
                else
                {
                    return level;
                }
            }
        }
        
        /*
        
            n 개의 퍼즐,
            퍼즐당 diffs, times,
            숙련도 level,
            
            diff <= level -> 원트 클
            diff > level 차만큼 틀림,
                틀린시간 + 이전 문제 한번 풀고 와서 더시 도전
                
            limit > 전체 제한시간 , 이 제한시간 안에 모든 포즐을 해결하기 위한 숙련도의 최솟값
        */
        
        

    }
    
    
    
    public long success(int  time, long restTime)
    {
        return restTime - time;
    }
    
    
    public long failed(int curTime, int prevTime,int diff,  long restTime)
    {

        restTime -= diff*(curTime + prevTime);
        
        return restTime -=curTime;
    }
    
}