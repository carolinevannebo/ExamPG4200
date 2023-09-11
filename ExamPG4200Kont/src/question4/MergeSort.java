package question4;

import java.util.Arrays;

// 4.1
public class MergeSort {
    private static final int[] array = {70, 50, 30, 10, 20, 40, 60};
    private static int mergeCount = 0;

    public static void main(String[] args) {

        System.out.println("Array before sorting: " + Arrays.toString(array));

        long startTime = System.nanoTime();

        mergeSort(array, 0, array.length -1);

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println("Array after sorting: " + Arrays.toString(array));

        System.out.println("\nNumber of merge operations: " + getMergeCount());
        System.out.println("Execution time: " + (executionTime/1000000000) + " seconds (" + executionTime + " nanoseconds)");

        resetMergeCount();
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle +1, right);

            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left +1;
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[middle + 1 + j];

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }

        mergeCount++;
    }

    private static int getMergeCount() {
        return mergeCount;
    }

    private static void resetMergeCount() {
        mergeCount = 0;
    }
}
