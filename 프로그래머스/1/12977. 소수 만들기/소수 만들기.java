import java.util.*;

class Solution {
    public int solution(int[] nums) {
        List<Integer> primes = new ArrayList<>();
        List<Integer> newNums = getNewNumbers(nums);

        for (int num : newNums) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }

        return primes.size();
    }

    public List<Integer> getNewNumbers(int[] nums) {
        List<Integer> newNums = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    newNums.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        return newNums;
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true; 
        if (n % 2 == 0) return false; 

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
