package algorithms.sorting;

/**
 * This class is used for implementing Strategy Design Patern.
 */
public enum SortingAlgoSelector {
    INSERT_SORT;

    static SortingAlgo select(SortingAlgoSelector selector){
        switch (selector) {
            case INSERT_SORT:
                
                return new InsertSort();
        
            default:
                return new InsertSort();
        }
    }
}
