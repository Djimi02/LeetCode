package algorithms.sorting;

public class QuickSort implements SortingAlgo {

    private int partition(int[] array, int low, int high) {
        int pivot = high;
        int left = low;

        for (int i = low; i <= high; i++) {
            if (array[i] < array[pivot]) {
                if (i != left) {
                    // swap pivot with left
                    int dummy = array[i];
                    array[i] = array[left];
                    array[left] = dummy;
                }
                left++;
            }
        }

        // swap pivot with left
        int dummy = array[pivot];
        array[pivot] = array[left];
        array[left] = dummy;

        return left;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = partition(array, low, high);
        
        quickSort(array, low, pivot - 1);
        quickSort(array, pivot + 1, high);
    }

    @Override
    public int[] sort(int[] array) {
        
        quickSort(array, 0, array.length - 1);

        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 6, 9, 3, 5};

        SortingAlgo algo = SortingAlgoSelector.select(SortingAlgoSelector.QUICK_SORT);
        array = algo.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
    
}