class Solution {
    public int arrangeCoins(int n) {
        long left = 0, right = n;
        
        while (left <= right) {
            long k = left + (right - left) / 2;
            long currentCoins = k * (k + 1) / 2;
            
            if (currentCoins == n) {
                return (int)k;
            }
            if (n < currentCoins) {
                right = k - 1;
            } else {
                left = k + 1;
            }
        }
        return (int)right;
    }
}