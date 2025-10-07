import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>(); // lake -> last day it rained
        TreeSet<Integer> dryDays = new TreeSet<>(); // stores indices of available dry days

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                dryDays.add(i);
                ans[i] = 1; // default (will be replaced later if needed)
            } else {
                ans[i] = -1;
                if (fullLakes.containsKey(lake)) {
                    // Find the dry day after last time it rained on this lake
                    Integer dryDay = dryDays.higher(fullLakes.get(lake));
                    if (dryDay == null) {
                        return new int[0]; // No available dry day → flood
                    }
                    ans[dryDay] = lake; // dry this lake on that dry day
                    dryDays.remove(dryDay);
                }
                fullLakes.put(lake, i); // update last rain day
            }
        }
        return ans;
    }
}
