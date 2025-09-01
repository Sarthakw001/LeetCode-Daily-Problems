class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        sort(people.begin(),people.end());
        int l = 0,r=people.size()-1;

        int minRescueBoat = 0;
        while(l<=r){
            int sumOfWeight = people[l] + people[r];
            if(sumOfWeight > limit){
                if(people[r] <= limit){
                    minRescueBoat++;
                    r--;
                }
            }else{
                minRescueBoat++;
                l++;r--;
            }
        }
        return minRescueBoat;
    }
};