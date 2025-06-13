// User function Template for Java
class Solution {
    public boolean isPowerOfAnother(int X, int Y) {
        // code here
        if (X == 1) {
            return Y == 1; 
        }

        while (Y > 1) {
            if (Y % X != 0) {
                return false;
            }
            Y = Y / X;
        }

        return true;
    }
}
