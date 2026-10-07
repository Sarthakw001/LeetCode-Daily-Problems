class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxBanana = piles[0];

        for (int pile : piles) {
            maxBanana = Math.max(maxBanana, pile);
        }

        int left = 1;
        int right = maxBanana;
        int minK = maxBanana;

        while (left <= right) {

            int k = left + (right - left) / 2;

            int hours = 0;

            for (int pile : piles) {
                hours += (pile + k - 1) / k;

                if (hours > h) {
                    break;
                }
            }

            if (hours > h) {
                // k is too slow
                left = k + 1;
            } else {
                // k works, try a smaller speed
                minK = k;
                right = k - 1;
            }
        }

        return minK;
    }
}