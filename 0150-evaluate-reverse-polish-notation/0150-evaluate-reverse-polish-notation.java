class Solution {
    static {
        Solution sol = new Solution();
        for(int i = 0; i < 500; i++){
            sol.evalRPN(new String[0]);
        }
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int n1 = st.pop();
                int n2 = st.pop();
                switch(s){
                    case "+" -> st.push(n2 + n1);
                    case "-" -> st.push(n2 - n1);
                    case "*" -> st.push(n2 * n1);
                    case "/" -> st.push(n2 / n1);
                }
            }
            else
                st.push(Integer.parseInt(s));
        }
        return st.isEmpty() ? 0 : st.pop(); 
    }
}