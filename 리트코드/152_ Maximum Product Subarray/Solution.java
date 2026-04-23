class Solution {
    public int maxProduct(int[] nums) {
        int bestProduct = nums[0];
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            
            if (value < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            maxEndingHere = Math.max(value, maxEndingHere * value);
            minEndingHere = Math.min(value, minEndingHere * value);
            bestProduct = Math.max(bestProduct, maxEndingHere);
        }

        return bestProduct;
    }
}
