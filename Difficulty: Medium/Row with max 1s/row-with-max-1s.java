// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int rows = arr.length;
        int cols = arr[0].length;

        int maxRow = -1;
        int j = cols - 1;

        for (int i = 0; i < rows; i++) {
            while (j >= 0 && arr[i][j] == 1) {
                j--;
                maxRow = i;
            }
        }

        return maxRow;
    }
}
