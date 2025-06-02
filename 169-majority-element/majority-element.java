class Solution {
    public int majorityElement(int[] num) {
        int n = num.length;
        int count = 0;
        int max = num[0];

        for(int i=0; i<n; i++){
            if(num[i] == max){
                count++;
            }
            else{
                count--;
                if(count == 0){
                   max = num[i];
                   count = 1;
                }
            }
        }
        return max;
    }
}