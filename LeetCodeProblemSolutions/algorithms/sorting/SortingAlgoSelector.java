package algorithms.sorting;

/**
 * This class is used for implementing Strategy Design Patern.
 */
public enum SortingAlgoSelector {
    INSERT_SORT,
    MERGE_SORT,
    QUICK_SORT;

    static SortingAlgo select(SortingAlgoSelector selector){
        switch (selector) {
            case INSERT_SORT:
                return new InsertSort();

            case MERGE_SORT:
                return new MergeSort();

            case QUICK_SORT:
                return new QuickSort();
        
            default:
                return new InsertSort();
        }
    }
}
