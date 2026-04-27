import java.util.Random;
import java.util.Arrays;
public class AlgorithmRunner {


    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }

        return array;
    }

    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }
        Arrays.sort(array);
        return array;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }
        Arrays.sort(array);
        for (int i = 0; i < size / 2; i++) {
            int oppositeIndex = size - 1 - i;
            int temp = array[i];
            array[i] = array[oppositeIndex];
            array[oppositeIndex] = temp;

        }
        return array;
    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }

        }
        return -1;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;

                }

            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;

        }

    }

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;

        }
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }
        mergeSort(left);
        mergeSort(right);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;

            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    public static void countingSort(int[] array) {
        // Якщо масив порожній або має 1 елемент - сортувати нічого
        if (array.length < 2) {
            return;
        }


        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }


        int[] countArray = new int[max - min + 1];


        for (int j = 0; j < array.length; j++) {
            countArray[array[j] - min]++;
        }


        int index = 0;
        for (int k = 0; k < countArray.length; k++) {
            while (countArray[k] > 0) {
                array[index] = k + min;
                index++;
                countArray[k]--;
            }
        }
    }

    public static int euclideanAlgorithm(int a, int b) {
        while (b != 0) {
            int remainder;
            remainder = a % b;
            a = b;
            b = remainder;

        }
        return a;
    }

    public static int kadaneAlgorithm(int[] array) {
        int maxSoFar = array[0];
        int currentMax = array[0];
        for (int i = 1; i < array.length; i++) {
            currentMax = Math.max(array[i], currentMax + array[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }
}






