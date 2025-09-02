class Solution {
public:
    int sumOfSquare(int n){
        int total = 0;
        while(n!=0){
            int digit = n % 10;
            total += digit * digit;
            n = n/10;
        }
        return total;
    }
    bool isHappy(int n) {
        int fast = n, slow = n;
        while(1){
            slow = sumOfSquare(slow);
            fast = sumOfSquare(sumOfSquare(fast));
            if(fast == 1 || slow == 1) return true;
            if(fast == slow) return false;
        }
        return true;
    }
};
