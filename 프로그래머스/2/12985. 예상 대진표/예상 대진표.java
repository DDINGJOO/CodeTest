class Solution
{
    public int solution(int n, int a, int b)
    {
        int count =0;
        
        while(a != b)
        {
            if( a%2 !=0){a +=1;} a/=2;
            if( b%2 !=0){b +=1;} b/=2;
            count++;
       }
        return count;
        
    }
    
    

}