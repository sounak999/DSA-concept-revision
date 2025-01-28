// Program to print array elements in Descending order
// using Merge Sort

import java.util.*;

class MergeSort {
    // utility func for merge sort
    public static void mergeSort(int[] arr) {
        int startIndex = 0, endIndex = arr.length - 1;
        solve(arr, startIndex, endIndex);
    }

    private static void solve(int[] arr, int start, int end) {
        if (start >= end) {
            return ;
        }

        int mid = start + (end - start) / 2; // to prevent overflow
        solve(arr, start, mid);
        solve(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int left = start, right = mid + 1;
        List<Integer> auxList = new ArrayList<>();

        // traverse through both the pointers
        while (left <= mid && right <= end) {
            if (arr[left] >= arr[right]) {
                auxList.add(arr[left]);
                ++left;
            } else {
                auxList.add(arr[right]);
                ++right;
            }
        }

        // remaining ones
        while (left <= mid) {
            auxList.add(arr[left]);
            ++left;
        }

        while (right <= end) {
            auxList.add(arr[right]);
            ++right;
        }

        // now place all items to its correct place
        // in the actual array
        for (int i=start; i<=end; i++) {
            arr[i] = auxList.get(i - start);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 3, 5, 5};
        mergeSort(arr);
        for (int x: arr) {
            System.out.print(x + " ");
        }
    }
}