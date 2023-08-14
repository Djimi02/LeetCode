import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public void resetCombination(int[] array, int pointer) {
        array[pointer] = array[pointer - 1] + 2;
        for (int i = pointer + 1; i < array.length; i++) {
            array[i] = array[i-1] + 1;
        }
    }

    public void addCombination(List<List<Integer>> output, int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        output.add(list);
    }

    public void recursion(List<List<Integer>> output, int[] array, int pointer, int n, int k) {
        if (array[pointer] + 1 > n - (k - pointer - 1)) {
            for (int i = pointer; i < array.length - 1; i++) {
                array[i + 1] = array[i] + 1;
            }
            return;
        }

        while (array[pointer] + 1 <= n - (k - pointer - 1)) {
            if (pointer + 1 <= k-1) {
                recursion(output, array, pointer + 1, n, k);
            }
            array[pointer]++;
            addCombination(output, array);
        }

        if (pointer != 0) {
            resetCombination(array, pointer);
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        int[] numbers = new int[k]; // Used to keep track of the k numbers
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 1; i <= numbers.length; i++) {
            numbers[i-1] = i;
        }
        addCombination(output, numbers);

        recursion(output, numbers, 0, n, k);

        return output;
    }

    public static void main(String[] args) {
        List<List<Integer>> output = new Combinations().combine(5, 3);

        for (List<Integer> list : output) {
            System.out.println(list);
        }
    }
}