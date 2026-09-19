class Solution {
    public int lengthOfLIS(int[] nums) {

        int[][] v1 = new int[nums.length][2];

        int size = 0;
        int i = 0;

        for (int a : nums) {

            if (size == 0 || a > v1[size - 1][0]) {
                v1[size][0] = a;
                v1[size][1] = i;
                size++;

            } else {

                int l = 0;
                int h = size - 1;
                int id = -1;
                
                while (l <= h) {
                    int mid = (l + h) / 2;

                    if (v1[mid][0] >= a) {
                        id = mid;
                        h = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }

                if (i > v1[id][1]) {
                    v1[id][0] = a;
                    v1[id][1] = i;
                }
            }

            i++;
        }

        return size;
    }
}