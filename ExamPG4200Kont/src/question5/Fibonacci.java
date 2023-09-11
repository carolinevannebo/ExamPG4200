package question5;

// 5.1
public class Fibonacci {
    private static int[] fibonacciSeries;
    public static void main(String[] args) {
        int n = 5;

        fibonacciSeries = new int[n + 1];

        System.out.println("\nSolving fibonacci recursively: ");

        long startTime = System.nanoTime();
        recursive(n);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        for (int i = 0; i <= n; i++){
            System.out.print(recursive(i) + " ");
        }

        System.out.println("\nExecution time: " + (executionTime/1000000000) + " seconds (" + executionTime + " nanoseconds)");

        System.out.println("\nSolving fibonacci iteratively: ");

        startTime = System.nanoTime();
        iterative(n);
        endTime = System.nanoTime();
        executionTime = endTime - startTime;

        for (int i = 0; i <= n; i++){
            System.out.print(iterative(i) + " ");
        }

        System.out.println("\nExecution time: " + (executionTime/1000000000) + " seconds (" + executionTime + " nanoseconds)");
    }

    private static int iterative(int n) {
        if (n <= 1) {
            return n;
        }

        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int next = first + second;
            first = second;
            second = next;
        }

        return second;
    }
    private static int recursive(int n) {
        if (n <= 1) {
            return n;
        }

        if (fibonacciSeries[n] != 0) {
            return fibonacciSeries[n];
        }

        int nthFibonacciNumber = (recursive(n -1) + recursive(n -2));
        fibonacciSeries[n] = nthFibonacciNumber;
        return nthFibonacciNumber;
    }
}
