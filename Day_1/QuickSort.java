public class QuickSort {
    // utility quick sort function (descending order)
    public static void quickSort(int[] arr) {
        int startIndex = 0, endIndex = arr.length - 1;
        solve(arr, startIndex, endIndex);
    }

    private static void solve(int[] arr, int left, int right) {
        if (left >= right) {
            return ;
        }

        int p = partition(arr, left, right);
        solve(arr, left, p - 1);
        solve(arr, p + 1, right);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];

        int i = start, j = end;
        while (i < j) {
            while (i < j && arr[i] > pivot) {
                ++i;
            }

            while (i < j && arr[j] <= pivot) {
                --j;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }
        
        // j would be at the <= place
        swap(arr, start, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 3, 5, 5};
        quickSort(arr);
        for (int x: arr) {
            System.out.print(x + " ");
        }
    }
}
