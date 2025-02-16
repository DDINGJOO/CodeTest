class Solution {
    public static int result =0;
    public int solution(int n) {
        for(int i = 1 ; i<n+1; i++)
        {   
            if(isPrime(i))
            {
                result++;
            }
        }
        return result;
    }
    public boolean isPrime(int n )
    {
        if(n<=1 ) return false;
        for(int i = 2 ; i*i <=n ; i++)
        {
            if(n%i ==0) return false;
        }
        
        return true;
    }
}