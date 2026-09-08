class Solution {
    long[] dp = new long[100022];

    long fun(int i, int[] nums, Map<Integer, Integer> m1) {
        if (i >= nums.length || i == -1)
        return 0;

        long curr = nums[i];

        if (dp[i] != -1)
        return dp[i];
        int id = -1;
        
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i] + 2) {
                id = j;
                break;
            }
        }
        long t = 1L * nums[i] * m1.get(nums[i]) + fun(id, nums, m1);

        long nt = fun(i + 1, nums, m1);
        return dp[i] = Math.max(t, nt);
    }
    public long maximumTotalDamage(int[] nums) {
        Map<Integer, Integer> m1 = new TreeMap<>();
        
        for (int a: nums){
            m1.put(a, m1.getOrDefault(a, 0) + 1);
        }
        int[] v1 = new int[m1.size()];
        int index = 0;
        for (int a:m1.keySet()) {
        v1[index++] = a;
        } 
        Arrays.fill(dp, -1);
        return fun(0, v1, m1);
    }
}