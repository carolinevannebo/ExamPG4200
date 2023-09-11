package question1;

// 1.2
public class ArrayTraversal {
    public static void main(String[] args)
    {
        int[] array = {10, 7, 11, 5, 13, 8, 38, 37, 14, 92, 84, 74, 77, 20, 40, 47, 33, 65, 62, 69, 73};
        int largest = findLargest(array);

        System.out.println("Largest element in array is " + largest);
    }

    static int findLargest(int[] array)
    {
        int maxValue = array[0];

        for (int i : array)
            if (i > maxValue)
                maxValue = i;

        return maxValue;
    }
}
