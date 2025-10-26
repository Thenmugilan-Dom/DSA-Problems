class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;     
        int days = n % 7;      
        int total = 0;

        total += 28 * weeks + (weeks * (weeks - 1) / 2) * 7;

        int start = 1 + weeks; 
        for (int i = 0; i < days; i++) {
            total += start + i;
        }

        return total;
    }
}
