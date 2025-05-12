//{ Driver Code Starts
// Initial Template for Java

import java.util.Scanner;

class Main {

    
// } Driver Code Ends

// User function Template for Java

public static int countDigits(int n) {

    // write your code here
    int a=0;
    while(n>0){
        a += 1;
        n /= 10;
    }
    // return number of digits in n
    return a;
}


//{ Driver Code Starts.

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            System.out.println(countDigits(n));

            System.out.println("~");
        }
        scn.close();
    }
}
// } Driver Code Ends