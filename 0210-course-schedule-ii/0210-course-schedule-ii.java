class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());

        for(int[] pre:prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0)
                q.offer(i);
        }

        int processed = 0;
        int[] courseOrder = new int[numCourses];
        while(!q.isEmpty()){
            int node = q.poll();
            courseOrder[processed++] = node;

            for(int neighbour : graph.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0)
                    q.offer(neighbour);
            }
        }
        return processed == numCourses ? courseOrder : new int[0];
    }
}