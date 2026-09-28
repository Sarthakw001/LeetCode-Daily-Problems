class Solution { 
    static {
        Solution sol = new Solution();
        for(int i = 0; i < 500; i++){
            sol.eraseOverlapIntervals(new int[][]{{1, 2}});
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int end = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } 
            else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}