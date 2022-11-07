import java.util.*;

/* sorting class */
public class Sorting {
    public static void mergeSort(int[] list) {
        int start = 0;
        int end = list.length - 1;
        mergeSortHelper(list, start, end);
    }

    /* implementation of heapsort */
    public static void heapSort(int[] list) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num : list) {
            minHeap.add(num);
        }
        int i = 0;
        while (!minHeap.isEmpty()) {
            list[i] = minHeap.poll();
            i++;
        }

    }

    /* impelmentation of merge sort */
    private static void mergeSortHelper(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSortHelper(arr, start, mid);
            mergeSortHelper(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    /* merge the subarrays */
    private static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[start + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    /* process string input to int[] */
    public static int[] getList(String line) {
        String[] list = line.split(" ");
        int[] nums = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            int num = Integer.parseInt(list[i]);
            nums[i] = num;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println("What sorting algorithm: \n1. MergeSort\n2. HeapSort");
        Scanner scanner = new Scanner(System.in);
        String choiceInput = scanner.nextLine();
        int choice = Integer.parseInt(choiceInput);
        System.out.println("Input the numbers...");
        String line = scanner.nextLine();
        int[] list = getList(line);
        System.out.println("List (before): " + Arrays.toString(list));
        if (choice == 1) {
            mergeSort(list);
        } else {
            heapSort(list);
        }
        System.out.println("List (after): " + Arrays.toString(list));
        scanner.close();
    }

}
