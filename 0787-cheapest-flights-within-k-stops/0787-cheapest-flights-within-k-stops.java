class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = distance.clone();
            boolean flag = false;

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if (distance[from] == Integer.MAX_VALUE) {
                    continue;
                }

                long candidate = (long) distance[from] + price;

                if (candidate < temp[to]) {
                    temp[to] = (int) candidate;
                    flag = true;
                }
            }

            distance = temp;

            if (!flag) {
                break;
            }
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}