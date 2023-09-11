package question3;

// 3.1
public class BinarySearch {
    private static final int[] array = {10, 12, 13, 14, 18, 20, 25, 27, 30, 35, 40, 45, 47};

    public static void main(String[] args) {
        int left = 0;
        int right = array.length -1;
        int target = 18;

        int recursionIndex = recursiveBinarySearch(array, left, right, target);

        if (recursionIndex != -1) {
            System.out.println("X = " + target + " found at index " + recursionIndex);
        } else {
            System.out.println("Could not find X");
        }
    }

    private static int recursiveBinarySearch(int[] array, int left, int right, int x) {
        if (left > right) {
            return -1;
        }
        //int middle = (left + right) / 2;
        int middle = left + (right - left) / 2;
        int middleValue = array[middle];


        if (x == middleValue) {
            return middle;
        }
        else if (x < middleValue) {
            return recursiveBinarySearch(array, left, middle -1, x);
        }
        else {
            return recursiveBinarySearch(array, middle + 1, right, x);
        }
    }

    private static int iterativeBinarySearch(int[] array, int left, int right, int x) {
        while (left <= right) {
            int middle = (left + right) / 2;
            int middleValue = array[middle];

            if (middleValue == x) {
                return array[middle];
            } else if (middleValue < x) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
