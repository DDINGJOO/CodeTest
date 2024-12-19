class Solution {
    public int solution(int n) {
        
        String str = new StringBuilder(Integer.toString(n,3)).reverse().toString();
        
        
        return Integer.valueOf(str,3);
    }
}