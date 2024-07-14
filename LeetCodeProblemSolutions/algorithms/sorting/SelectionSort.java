package algorithms.sorting;

public class SelectionSort implements SortingAlgo {
 
    @Override
    public int[] sort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[iMin] > array[j]) {
                    iMin = j;
                }
            }
            if (iMin != i) {
                int dummy = array[iMin];
                array[iMin] = array[i];
                array[i] = dummy;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 5, 9, 3};

        SortingAlgo algo = SortingAlgoSelector.select(SortingAlgoSelector.SELECTION_SORT);

        array = algo.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}