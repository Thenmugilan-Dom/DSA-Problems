class Solution {
    public int xorOperation(int n, int start) {
        int count = 0;
        int xor =start;
        int i = start+2;
        while(count<n-1){
            xor = xor^i;
            i=i+2;
            count++;
        }
        // int xor = 0^8;
        return xor;
    }
}