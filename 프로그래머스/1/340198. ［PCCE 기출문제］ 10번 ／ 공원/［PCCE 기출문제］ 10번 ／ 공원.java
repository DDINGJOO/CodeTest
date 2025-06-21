class Solution {
    public int solution(int[] mats, String[][] park) {
        // mats = { 1,2,3,4}
        //park = point
        int answer = -1;
        
        for(int i =0 ; i < park.length ; i++)
        {
            for(int j = 0 ; j < park[0].length; j++)
            {
                if(park[i][j].equals("-1"))
                {
                    for(int k : mats)
                    {
                        int tmp = check_layer(park,k,i,j);
                        if(answer <= tmp)
                        {
                            answer =tmp;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    
    public int check_layer(String[][] park, int size , int x , int y )
    {
        System.out.println(size);
        for(int i = 0 ; i< size; i++)
        {
            for(int j =0 ; j< size ; j++)
            {
                if(x+i >= park.length || y+j >= park[0].length)
                {
                    return -1;
                }
                else if(!park[x+i][y+j].equals("-1"))
                {
                    System.out.print(park[x+i][y+j]);
                        return -1;
                }
            }
        }
        return size;
    }
}