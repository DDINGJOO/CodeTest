import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static Set<Integer> primes = new HashSet<>();
    public int solution(String numbers) {
        List<Integer> num = numbers.chars()
            .map(c -> c - '0')
            .boxed()
            .collect(Collectors.toList());
        sol(0,num);
        return primes.size();
    }
    
    
    public void sol(int acc, List<Integer> numbers)
    {
        if(isPrime(acc))
           { primes.add(acc);}
        for(int i =0 ; i < numbers.size(); i ++)
        {
            int nextAcc = acc *10 + numbers.get(i);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(i);
            sol(nextAcc,nextNumbers);
        }
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