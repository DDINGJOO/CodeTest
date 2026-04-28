class Solution {
    public int singleNumber(int[] nums) {
        int first = 0;
        int second = 0;

        for (int num : nums) {
            first = (first ^ num) & ~second;
            second = (second ^ num) & ~first;
        }

        return first;
    }
}
