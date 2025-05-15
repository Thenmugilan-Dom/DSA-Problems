//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    void mergeSort(int arr[], int l, int r) {
        if (l == r) {
            return;
        }

        int mid =l+(r-l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    void merge(int arr[], int left, int mid, int right) {
        ArrayList<Integer> temp = new ArrayList<>();
        int l = left;
        int r = mid + 1;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp.add(arr[l++]);
            } else {
                temp.add(arr[r++]);
            }
        }

        while (l <= mid) {
            temp.add(arr[l++]);
        }

        while (r <= right) {
            temp.add(arr[r++]);
        }
        
        for (int i = left; i <= right; i++) {
            arr[i] = temp.get(i - left);
        }
    }
}

