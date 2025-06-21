// User function Template for Java

class Solution {
    int median(int mat[][]) {
        // code here
        int r = mat.length;
        int c = mat[0].length;

        int low = 1;
        int high = 2000; 

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;

            for (int i = 0; i < r; i++) {
                count += countLessThanOrEqual(mat[i], mid);
            }

            if (count <= (r * c) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
    
    private int countLessThanOrEqual(int[] row, int target) {
        int low = 0, high = row.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}