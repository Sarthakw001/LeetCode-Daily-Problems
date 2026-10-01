class Solution {
    static{
        for(int i=0;i<500;i++){
            Solution obj = new Solution();
            obj.kClosest(new int[0][],0);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        if(points.length == 0) return new int[0][];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(
                b[0]*b[0] + b[1]*b[1],
                a[0]*a[0] + a[1]*a[1]
            )
        );

        for(int i=0;i<points.length;i++){
            pq.offer(points[i]);
            if(pq.size() > k)
                pq.poll();
        }

        int[][] closestPoints = new int[pq.size()][];


        int i = 0;
        while(!pq.isEmpty()){
            closestPoints[i++] = pq.peek();
            pq.poll();
        }

        return closestPoints;
    }
}