class Solution {
    public void printNos(int n) {
        // Code here
        print(1,n);
    }
    
    public void print(int current, int n){
        if(current > n){
            return;
        }
        System.out.print(current + " ");
        print(current + 1, n);
    }
}
