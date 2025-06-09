/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    int floorSqrt(int n) {
        // Your code here
        int l = 0;
        int h = n;
        int ans =1;
        while(l<=h){
            int mid = (l+h)/2;
            if(mid*mid<=n){
                ans = mid;
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return  ans;
    }
}