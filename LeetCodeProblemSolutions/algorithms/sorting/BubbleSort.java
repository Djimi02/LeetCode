package algorithms.sorting;

public class BubbleSort implements SortingAlgo {

    @Override
    public int[] sort(int[] array) {
        
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    int dummy = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = dummy;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 5, 9, 3, 6};

        SortingAlgo algo = SortingAlgoSelector.select(SortingAlgoSelector.BUBBLE_SORT);

        array = algo.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
    
}