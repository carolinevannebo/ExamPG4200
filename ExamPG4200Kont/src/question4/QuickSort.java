package question4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 4.2
public class QuickSort {
    private static int comparisons = 0;

    public static void main(String[] args) {

        // Shuffling the array helps avoid worst-case scenario by randomizing data
        Integer[] integerArray = {15, 22, 13, 27, 12, 10, 20, 25};
        List<Integer> integerList = Arrays.asList(integerArray);
        Collections.shuffle(integerList);

        Integer[] array = integerList.toArray(integerArray);

        System.out.println("Array before sorting: " + Arrays.toString(array));
        long startTime = System.nanoTime();

        quickSort(array, 0, array.length - 1);

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println("Array after sorting: " + Arrays.toString(array));
        System.out.println("\nNumber of comparisons: " + getComparisons());
        System.out.println("Execution time: " + (executionTime/1000000000) + " seconds (" + executionTime + " nanoseconds)");

        resetComparisons();
    }

    private static void quickSort(Integer[] array, int left, int right) {
        if (left < right) {
            int pi = partition(array, left, right);

            quickSort(array, left, pi - 1);
            quickSort(array, pi + 1, right);
        }
    }

    private static int partition(Integer[] array, int left, int right) {
        int pivot = array[right];
        int i = (left -1);

        for (int j = left; j < right; j++) {
            comparisons++;

            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;

        return i + 1;
    }

    private static int getComparisons() {
        return comparisons;
    }

    private static void resetComparisons() {
        comparisons = 0;
    }
}
