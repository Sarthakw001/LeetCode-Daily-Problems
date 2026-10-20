class Solution {
    public int climbStairs(int n) {
        int firstStair = 1;
        int secondStair = 2;

        for(int i=3;i<=n;i++){
            int finalAns = firstStair + secondStair;    
            firstStair = secondStair;
            secondStair = finalAns;
        }
        return n == 1 ? firstStair : secondStair;
    }
}