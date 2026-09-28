class Solution {
    static{
        Solution obj = new Solution();
        for(int i=0;i<500;i++)
            obj.isValid("");
    }
    public boolean isValid(String s) {
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