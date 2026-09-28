class Solution {
    static{
        Solution obj = new Solution();
        for(int i=0;i<=1000;i++)
            obj.isValid("");
    }
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for(char c:s.toCharArray()){
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                char ch = stack.peek();
                if((ch == '(' && c == ')') || (ch == '[' && c == ']') || (ch == '{' && c == '}'))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}