class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        int[] ends = new int[n];
        for(int i=0; i<n; i++) {
            ends[i] = intervals[i][1];
        }
        Arrays.sort(ends);
        long total = (long) n * (n-1) / 2;
        long disjoint = 0;
        for(int[] iv : intervals){
            int l = 0, hi = n;
            while(l < hi){
                int mid = (l + hi) >>> 1;
                if(ends[mid] < iv[0]) l = mid + 1;
                else hi = mid;
            }
            disjoint += l;
        }
            
        return total - disjoint;
    }
}