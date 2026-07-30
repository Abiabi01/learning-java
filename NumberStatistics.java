import java.util.Scanner;

public class NumberStatistics {

    public static int findMax(int[] arr) {
        int max = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];

        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }

    public static double findAverage(int[] arr) {
        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        return (double) sum / arr.length;
    }

    public static int countEvenNumbers(int[] arr) {
        int count = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[10];

        System.out.println("Enter 10 integers:");

        for (int i = 0; i < numbers.length; i++) {

            while (true) {

                System.out.print("Number " + (i + 1) + ": ");

                if (sc.hasNextInt()) {
                    numbers[i] = sc.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input! Please enter an integer.");
                    sc.next(); // Remove the invalid input
                }
            }
        }

        System.out.println();

        System.out.println("Maximum     : " + findMax(numbers));
        System.out.println("Minimum     : " + findMin(numbers));
        System.out.println("Average     : " + findAverage(numbers));
        System.out.println("Even Count  : " + countEvenNumbers(numbers));

        sc.close();
    }
}