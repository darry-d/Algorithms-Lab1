import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

public class AlgorithmBenchmarks {

    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    // ================= ЛІНІЙНИЙ ПОШУК =================
    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testLinearSearch_Best() {
        int[] array = AlgorithmRunner.generateRandomArray(100000);
        AlgorithmRunner.linearSearch(array, array[0]);
    }

    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testLinearSearch_Average() {
        int[] array = AlgorithmRunner.generateRandomArray(100000);
        AlgorithmRunner.linearSearch(array, 4790);
    }

    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testLinearSearch_Worst() {
        int[] array = AlgorithmRunner.generateRandomArray(100000);
        AlgorithmRunner.linearSearch(array, -1);
    }

    // ================= СОРТУВАННЯ ВИБОРОМ =================
    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testSelectionSort_Best() {
        int[] array = AlgorithmRunner.generateSortedArray(100000);
        AlgorithmRunner.selectionSort(array);
    }

    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testSelectionSort_Average() {
        int[] array = AlgorithmRunner.generateRandomArray(100000);
        AlgorithmRunner.selectionSort(array);
    }

    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testSelectionSort_Worst() {
        int[] array = AlgorithmRunner.generateReverseSortedArray(100000);
        AlgorithmRunner.selectionSort(array);
    }

    // ================= СОРТУВАННЯ ЗЛИТТЯМ =================
    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testMergeSort_Best() {
        int[] array = AlgorithmRunner.generateSortedArray(100000);
        AlgorithmRunner.mergeSort(array);
    }

    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testMergeSort_Average() {
        int[] array = AlgorithmRunner.generateRandomArray(100000);
        AlgorithmRunner.mergeSort(array);
    }

    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testMergeSort_Worst() {
        int[] array = AlgorithmRunner.generateReverseSortedArray(100000);
        AlgorithmRunner.mergeSort(array);
    }

    // ================= СОРТУВАННЯ ПІДРАХУНКОМ =================
    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testCountingSort_Best() {
        int[] array = AlgorithmRunner.generateSortedArray(100000);
        AlgorithmRunner.countingSort(array);
    }

    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testCountingSort_Average() {
        int[] array = AlgorithmRunner.generateRandomArray(100000);
        AlgorithmRunner.countingSort(array);
    }

    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testCountingSort_Worst() {
        int[] array = AlgorithmRunner.generateReverseSortedArray(100000);
        AlgorithmRunner.countingSort(array);
    }

    // ================= АЛГОРИТМ ЕВКЛІДА =================
    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testEuclidean_Best() {
        AlgorithmRunner.euclideanAlgorithm(1000000, 500000);
    }

    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testEuclidean_Average() {
        AlgorithmRunner.euclideanAlgorithm(987654321, 123456789);
    }

    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testEuclidean_Worst() {
        AlgorithmRunner.euclideanAlgorithm(1836311903, 1134903170);
    }

    // ================= АЛГОРИТМ КАДАНЕ =================
    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testKadane_Best() {
        int[] array = AlgorithmRunner.generateSortedArray(100000);
        AlgorithmRunner.kadaneAlgorithm(array);
    }

    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testKadane_Average() {
        int[] array = AlgorithmRunner.generateRandomArray(100000);
        AlgorithmRunner.kadaneAlgorithm(array);
    }

    @BenchmarkOptions(warmupRounds = 1, benchmarkRounds = 3)
    @Test
    public void testKadane_Worst() {
        int[] array = AlgorithmRunner.generateReverseSortedArray(100000);
        AlgorithmRunner.kadaneAlgorithm(array);
    }
}