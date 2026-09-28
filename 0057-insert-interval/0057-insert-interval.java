class Solution {
    static {
        Solution sol = new Solution();
        for(int i = 0; i < 500; i++){
            sol.insert(new int[0][],new int[0]);
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ls = new ArrayList<>();

        int i = 0;
        while(i<intervals.length && intervals[i][1] < newInterval[0])
            ls.add(intervals[i++]);
        
        while(i<intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        ls.add(newInterval);

        while (i < intervals.length) {
            ls.add(intervals[i]);
            i++;
        }

        return ls.toArray(new int[ls.size()][]);
    }
}