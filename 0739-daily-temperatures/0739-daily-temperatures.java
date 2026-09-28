class Solution {
    static {
        Solution sol = new Solution();
        for(int i = 0; i < 500; i++){
            sol.dailyTemperatures(new int[0]);
        }
    }

    class Pair{
        int value;
        int idx;

        Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Pair> st = new ArrayDeque<>();
        int[] op = new int[temperatures.length];

        for(int i=temperatures.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek().value <= temperatures[i])
                st.pop();
            if(st.isEmpty())
                op[i] = 0;
            else{
                op[i] = st.peek().idx - i;
            }
            st.push(new Pair(temperatures[i],i));
        }

        return op;
    }
}