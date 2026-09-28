class Solution {
    static {
        Solution sol = new Solution();
        for(int i = 0; i < 500; i++){
            sol.decodeString("");
        }
    }
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                StringBuilder st = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    st.append(stack.pop());
                }
                stack.pop(); 

                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0)))
                    num.append(stack.pop());
                num.reverse();
                int freq = Integer.parseInt(num.toString());

                String original = st.toString();
                for (int i = 1; i < freq; i++) {
                    st.append(original);
                }
                stack.push(st.toString());
            } else 
                stack.push(String.valueOf(ch));
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty())
            ans.append(stack.pop());

        return ans.reverse().toString();
    }
}