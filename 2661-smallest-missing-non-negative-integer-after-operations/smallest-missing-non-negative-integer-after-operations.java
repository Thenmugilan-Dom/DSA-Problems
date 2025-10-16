class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];

        for (int num : nums) {
            int rem = ((num % value) + value) % value; 
            freq[rem]++;
        }

        int mex = 0;

        while (true) {
            int rem = mex % value;
            if (freq[rem] == 0) break; 
            freq[rem]--; 
            mex++;
        }

        return mex;
    }
}
