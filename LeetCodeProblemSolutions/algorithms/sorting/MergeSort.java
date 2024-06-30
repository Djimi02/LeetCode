package algorithms.sorting;

public class MergeSort implements SortingAlgo {

    private int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        int pointerA = 0;
        int pointerB = 0;
        int pointerC = 0;

        while (pointerA < a.length && pointerB < b.length) {
            if (a[pointerA] <= b[pointerB]) {
                c[pointerC] = a[pointerA];
                pointerA++;
            } else {
                c[pointerC] = b[pointerB];
                pointerB++;
            }
            pointerC++;
        }

        while (pointerA < a.length) {
            c[pointerC] = a[pointerA];
            pointerA++;
            pointerC++;
        }

        while (pointerB < b.length) {
            c[pointerC] = b[pointerB];
            pointerB++;
            pointerC++;
        }

        return c;
    }
    
    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array should not be null!");
        }
        if (array.length <= 1) {
            return array;
        }

        // Split in two
        int[] a = new int[array.length / 2];
        int[] b = new int[array.length - a.length];
        for (int i = 0; i < array.length; i++) {
            if (i < array.length / 2) {
                a[i] = array[i];
            } else {
                b[i - a.length] = array[i];
            }
        }

        a = sort(a);
        b = sort(b);

        return merge(a, b);
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 5, 9, 3, 6};

        SortingAlgo algo = SortingAlgoSelector.select(SortingAlgoSelector.MERGE_SORT);

        array = algo.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
}