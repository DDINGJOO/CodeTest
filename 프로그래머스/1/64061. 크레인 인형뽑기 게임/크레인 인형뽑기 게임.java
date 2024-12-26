import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Stack<Integer> basket = new Stack<>();   
        int answer = 0;
        basket.push(-1);
        
        
        
        
        
        for(int i : moves)
        {
            i--;
            for(int j = 0 ; j < board.length ;j++)
            {
                if(board[j][i] == 0)
                {
                    continue;
                }
                else
                {
                    if(basket.peek() == board[j][i])
                    {
                        basket.pop();
                        answer++;
                    }
                    else
                    {
                        basket.push(board[j][i]);
                    }
                    board[j][i] = 0;
                    break;
                }
            }
        }
        
        
        
        return answer*2;
    }
}