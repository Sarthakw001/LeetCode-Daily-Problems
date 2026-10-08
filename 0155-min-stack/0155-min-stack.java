class MinStack {
    Deque<Integer> st;
    Deque<Integer> minSt;
    public MinStack() {
        minSt = new ArrayDeque<>();
        st = new ArrayDeque<>();
    }
    
    public void push(int value) {
        st.push(value);
        if(minSt.isEmpty() || value <= minSt.peek())
            minSt.push(value);
    }
    
    public void pop() {
        if(!minSt.isEmpty() && !st.isEmpty() && minSt.peek().equals(st.peek()))
            minSt.pop();
        if(!st.isEmpty())
            st.pop();
        
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */