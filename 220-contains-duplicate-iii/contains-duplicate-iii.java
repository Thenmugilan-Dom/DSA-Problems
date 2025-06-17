class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
         if (valueDiff < 0) return false; 
        
        Map<Long, Long> map = new HashMap<>();
        long size = (long) valueDiff + 1;

        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];
            long n = getvalue(num, size);

            if (map.containsKey(n)) {
                return true;
            }
            if (map.containsKey(n - 1) && Math.abs(num - map.get(n - 1)) <= valueDiff) {
                return true;
            }

            if (map.containsKey(n + 1) && Math.abs(num - map.get(n + 1)) <= valueDiff) {
                return true;
            }

            map.put(n, num);
            if (i >= indexDiff) {
                long old = getvalue((long) nums[i - indexDiff], size);
                map.remove(old);
            }
        }

        return false;
    }
     private long getvalue(long num, long n) {
        return num < 0 ? (num + 1) / n - 1 : num / n;
    }
}