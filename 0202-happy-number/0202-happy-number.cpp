class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> st;

        while(n != 1){
            if(st.count(n)) return false;
            st.insert(n);
            long long sum = 0,temp = n;
            while(temp!=0){
                int x = temp%10;
                sum += (long long) x * x;
                temp = temp/10;
            }
            n = sum;
        }
        return true;
    }
};