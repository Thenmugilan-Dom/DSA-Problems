//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().missingNum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int missingNum(int arr[]) {
        int n = arr.length;
        
        int xorAll = 0;
        int xorArr = 0;
        
        for (int i = 1; i <= n + 1; i++) {
            xorAll ^= i;
        }
        
        for (int num : arr) {
            xorArr ^= num;
        }
        
        return xorAll ^ xorArr;
    }
}
