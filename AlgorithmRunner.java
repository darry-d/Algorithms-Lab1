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
    public static int kadaneAlgorithm ( int [] array) {
        int maxSoFar = array[0];
        int currentMax = array[0];
        for ( int i = 1; i < array.length; i++){
            currentMax = Math.max(array[i], currentMax + array[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
    return maxSoFar;
    }







    public static void main(String[] args) {
        System.out.println("Лінійний пошук");
        int[] testArray = AlgorithmRunner.generateRandomArray(100000);

        long start1 = System.nanoTime();
        AlgorithmRunner.linearSearch(testArray, testArray[0]);
        long end1 = System.nanoTime();
        System.out.println("Найкращий випадок: " + (end1 - start1));

        long start2 = System.nanoTime();
        AlgorithmRunner.linearSearch(testArray, 4790);
        long end2 = System.nanoTime();
        System.out.println("Середній випадок: " + (end2 - start2));

        long start3 = System.nanoTime();
        AlgorithmRunner.linearSearch(testArray, -1);
        long end3 = System.nanoTime();
        System.out.println("Найгірший випадок: " + (end3 - start3));


        System.out.println("Сортування вибором");

        int[] bestArray = AlgorithmRunner.generateSortedArray(100000);
        long startSort1 = System.nanoTime();
        AlgorithmRunner.selectionSort(bestArray);
        long endSort1 = System.nanoTime();
        System.out.println("Найкращий випадок: " + (endSort1 - startSort1));

        int[] avgArray = AlgorithmRunner.generateRandomArray(100000);
        long startSort2 = System.nanoTime();
        AlgorithmRunner.selectionSort(avgArray);
        long endSort2 = System.nanoTime();
        System.out.println("Середній випадок:  " + (endSort2 - startSort2));


        int[] worstArray = AlgorithmRunner.generateReverseSortedArray(100000);
        long startSort3 = System.nanoTime();
        AlgorithmRunner.selectionSort(worstArray);
        long endSort3 = System.nanoTime();
        System.out.println("Найгірший випадок: " + (endSort3 - startSort3));


        System.out.println("Сортування злиттям");

        int[] bestMerge = AlgorithmRunner.generateRandomArray(100000);
        long startMerge1 = System.nanoTime();
        AlgorithmRunner.mergeSort(bestMerge);
        long endMerge1 = System.nanoTime();
        System.out.println("Найкращий випадок: " + (endMerge1 - startMerge1));


        int[] avgMerge = AlgorithmRunner.generateRandomArray(100000);
        long startMerge2 = System.nanoTime();
        AlgorithmRunner.mergeSort(avgMerge);
        long endMerge2 = System.nanoTime();
        System.out.println("Середній випадок:  " + (endMerge2 - startMerge2) );


        int[] worstMerge = AlgorithmRunner.generateReverseSortedArray(100000);
        long startMerge3 = System.nanoTime();
        AlgorithmRunner.mergeSort(worstMerge);
        long endMerge3 = System.nanoTime();
        System.out.println("Найгірший випадок: " + (endMerge3 - startMerge3) );


        System.out.println("Сортування підрахунком");

        int[] bestCount = AlgorithmRunner.generateSortedArray(100000);
        long startCount1 = System.nanoTime();
        AlgorithmRunner.countingSort(bestCount);
        long endCount1 = System.nanoTime();
        System.out.println("Найкращий випадок: " + (endCount1 - startCount1));


        int[] avgCount = AlgorithmRunner.generateRandomArray(100000);
        long startCount2 = System.nanoTime();
        AlgorithmRunner.countingSort(avgCount);
        long endCount2 = System.nanoTime();
        System.out.println("Середній випадок:  " + (endCount2 - startCount2) );


        int[] worstCount = AlgorithmRunner.generateReverseSortedArray(100000);
        long startCount3 = System.nanoTime();
        AlgorithmRunner.countingSort(worstCount);
        long endCount3 = System.nanoTime();
        System.out.println("Найгірший випадок: " + (endCount3 - startCount3) );

        System.out.println("Алгоритм Евкліда");

        long startGcd1 = System.nanoTime();
        AlgorithmRunner.euclideanAlgorithm(1000000, 500000);
        long endGcd1 = System.nanoTime();
        System.out.println("Найкращий випадок: " + (endGcd1 - startGcd1));


        long startGcd2 = System.nanoTime();
        AlgorithmRunner.euclideanAlgorithm(987654321, 123456789);
        long endGcd2 = System.nanoTime();
        System.out.println("Середній випадок:  " + (endGcd2 - startGcd2) );


        long startGcd3 = System.nanoTime();
        AlgorithmRunner.euclideanAlgorithm(1836311903, 1134903170);
        long endGcd3 = System.nanoTime();
        System.out.println("Найгірший випадок: " + (endGcd3 - startGcd3) );

        System.out.println(" Алгоритм Кадане ");


        int[] bestKadane = AlgorithmRunner.generateSortedArray(100000);
        long startKadane1 = System.nanoTime();
        AlgorithmRunner.kadaneAlgorithm(bestKadane);
        long endKadane1 = System.nanoTime();
        System.out.println("Найкращий випадок: " + (endKadane1 - startKadane1) );


        int[] avgKadane = AlgorithmRunner.generateRandomArray(100000);
        long startKadane2 = System.nanoTime();
        AlgorithmRunner.kadaneAlgorithm(avgKadane);
        long endKadane2 = System.nanoTime();
        System.out.println("Середній випадок:  " + (endKadane2 - startKadane2) );


        int[] worstKadane = AlgorithmRunner.generateReverseSortedArray(100000);
        long startKadane3 = System.nanoTime();
        AlgorithmRunner.kadaneAlgorithm(worstKadane);
        long endKadane3 = System.nanoTime();
        System.out.println("Найгірший випадок: " + (endKadane3 - startKadane3) );
    }
    }




