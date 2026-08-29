class Solution {

    void fun(int index, int[] nums, int target,
             List<Integer> op, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(op));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {

            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > target) {
                break;
            }

            op.add(nums[i]);

            fun(i + 1, nums, target - nums[i],
                op, ans);

            op.remove(op.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        Arrays.sort(nums);

        fun(0, nums, target, output, ans);

        return ans;
    }
}