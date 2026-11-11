

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // pair each car as {position, speed}
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // sort by position, closest to target first (descending)
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;
        double lastTime = 0;

        for (int i = 0; i < n; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];

            // if this car takes longer than the fleet ahead, it can't catch up
            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
            // otherwise it catches up and joins that fleet
        }

        return fleets;
    }
}