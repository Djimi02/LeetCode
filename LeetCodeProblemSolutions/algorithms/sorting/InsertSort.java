package algorithms.sorting;

public class InsertSort implements SortingAlgo {

    @Override
    public void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array should not be null!");
        }
        if (array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int a = array[j];
                    array[j] = array[j+1];
                    array[j+1] = a;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 5, 9, 3};

        SortingAlgo algo = SortingAlgoSelector.select(SortingAlgoSelector.INSERT_SORT);

        algo.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
    
}