import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n) {


        //  n*n 빈 캔버스
        Snail snail = new Snail(n);
        int num =1;
        int max = (n*(n+1))/2;
        while(num != max)
        {
            if(num != max)
            {
                num = snail.down(num);
            }
            if(num != max)
            {
                num = snail.next(num);
            }
            if(num != max)
            {
                num = snail.up(num);
            }
        }

        // 판단 우선순위
        /*
            아래로 이동 -> y +1 //  n까지 혹은 뭔가 있을때
            아래로 X -> 오른쪽으로 이동 -> x+1 // n 까지 혹은 뭔가 있으때
            아래 X 오른쪽 X -> 위로 이동 -> 위칸이 차있을때 까지 -> 아래로 이동 y-1 x-1

            탈출조건 : num ==  (n*(n+1))/2?
        */




        int[] answer = new int[max];
        int index =0;
        for(int i=0 ;i<n; i++)
        {
            for(int j=0 ; j<=i; j++)
            {
                answer[index] = snail.tri[i][j];
                index++;
            }
        }

        return answer;
    }
}



class Snail
{
    int[][] tri;
    int n;
    int x;
    int y;

    public Snail(int n)
    {
        this.tri =new int[n][n];
        this.tri[0][0] = 1;
        this.x = 0;
        this.y =0;
        this.n = n;
    }

    public int down(int num)
    {
        int k = num;
        while(true)
        {
            if(y+1 != n && tri[y+1][x] ==0)
            {
                this.y +=1;
                k++;
                tri[y][x] = k;

            }
            else
            {
                break;
            }
        }
        return k;
    }

    public int next(int num)
    {
        int k = num;
        while(true)
        {
            if(x+1 !=n && tri[y][x+1] == 0)
            {
                this.x +=1;
                k++;
                tri[y][x] = k;



            }
            else
            {
                break;
            }
        }
        return k;
    }

    public int up(int num)
    {
        int k = num;
        while(true)
        {
            if(tri[y-1][x-1] == 0 )
            {
                this.x -=1;
                this.y -=1;
                k++;
                tri[y][x] = k;


            }
            else
            {
                break;
            }
        }
        return k;
    }
}