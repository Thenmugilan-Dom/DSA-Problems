class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0, max = 0;

        for (int w : weights) {
            min = Math.max(min, w); 
            max += w;               
        }

        int answer = max;
        while (min <= max) {
            int mid = (min + max) / 2;
            int requiredDays = numberofday(weights, mid);
            
            if (requiredDays > days) {
                min = mid + 1;
            } else {
                answer = mid; 
                max = mid - 1;
            }
        }

        return answer;
    }

    public int numberofday(int[] weights, int capacity) {
        int days = 1;
        int currentWeight = 0;
        
        for (int w : weights) {
            if (currentWeight + w > capacity) {
                days++;
                currentWeight = 0;
            }
            currentWeight += w;
        }
        
        return days;
    }
}
