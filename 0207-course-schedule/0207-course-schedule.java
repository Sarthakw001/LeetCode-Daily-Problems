class Solution {
    List<Integer>[] graph;
    int[] state;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        state = new int[numCourses];

        for(int i=0;i<numCourses;i++)
            graph[i]=new ArrayList<>();

        for(int[] preRequisite:prerequisites){
            int course = preRequisite[0];
            int preRequisiteCourse = preRequisite[1];

            graph[preRequisiteCourse].add(course);
        }

        for(int i=0;i<numCourses;i++){
            if(!dfs(i))
                return false;
        }
        return true;
    }

    private boolean dfs(int course){
        if(state[course] == 1) return false;
        if(state[course] == 2) return true;

        state[course] = 1;
        for(int next:graph[course]){
            if(!dfs(next))
                return false;
        }
        state[course] = 2;
        return true;
    }
}