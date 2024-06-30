package algorithms.sorting;

public class InsertSort implements SortingAlgo {

    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array should not be null!");
        }
        if (array.length <= 1) {
            return array;
        }

        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j-1] > array[j]) {
                int dummy = array[j];
                array[j] = array[j-1];
                array[j-1] = dummy;
                j--;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 5, 9, 3};

        SortingAlgo algo = SortingAlgoSelector.select(SortingAlgoSelector.INSERT_SORT);

        array = algo.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
    
}