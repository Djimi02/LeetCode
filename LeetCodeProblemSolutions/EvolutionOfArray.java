import java.util.ArrayList;
import java.util.List;

public class EvolutionOfArray {
    private final int[][] solutions0 = { {1,1,1}, {1,1,0}, {1, 0, 1}, {0, 0, 0} };
    private final int[][] solutions1 = { {1, 0, 0}, {0, 1, 1}, {0, 1, 0}, {0, 0, 1} };

    public void deleteAllSolutionsWithLengthUnderX(List<List<Integer>> globalSolution, int x) {
        boolean condition = true;
        while (condition) {
            condition = false;
            for (int i = 0; i < globalSolution.size(); i++) { // Removes solutions that will not lead to answer
                if (globalSolution.get(i).size() < x) {
                    globalSolution.remove(i);
                    condition = true;
                }
            }
        }
    }

    public void concatenateSolutions(List<Integer> solution1, int startIndex, int[] solution2) {
        if (startIndex == 0) {
            solution1.add(solution2[1]);
            solution1.add(solution2[2]);
        } else if (startIndex == solution1.size()) {
            // do nothing, shouldnt happen
        } else {
            solution1.add(solution2[2]);
        }
    }

    public boolean checkForOverlapAndConcat(List<List<Integer>> globalSolution, int indexOfElement, int lengthOfA, int[][] arrayOfSolutions) {
        boolean[] usedSolutions = {false, false, false, false};

        int numberOfSolutions = globalSolution.size();
        for (int indexOfSolution = 0; indexOfSolution < numberOfSolutions; indexOfSolution++) {

            for (int i = 0; i < arrayOfSolutions.length; i++) {
                if (usedSolutions[i]) {
                    continue;
                }

                if (indexOfElement == 0) { // If the element is the very first one
                    if (0 == arrayOfSolutions[i][0]) { // check only the left element which is outside the array
                        List<Integer> extendedSolution = new ArrayList<>();
                        extendedSolution.addAll(globalSolution.get(indexOfSolution)); // make a copy of the solution
                        
                        concatenateSolutions(extendedSolution, indexOfElement, arrayOfSolutions[i]); // concatenate to the solution

                        globalSolution.add(extendedSolution); // Add the extended solution

                        usedSolutions[i] = true;
                        continue;
                    } 
                } else if (indexOfElement == lengthOfA - 1) { // If the element is the last one
                    if ( // check all 3 elements
                    globalSolution.get(indexOfSolution).get(indexOfElement - 1) == arrayOfSolutions[i][0] &&
                    globalSolution.get(indexOfSolution).get(indexOfElement) == arrayOfSolutions[i][1] &&
                    0 == arrayOfSolutions[i][2]
                    ) {
                        return true;
                    }
                } else if ( // dont check the right element as it should be -1
                    globalSolution.get(indexOfSolution).get(indexOfElement - 1) == arrayOfSolutions[i][0] &&
                    globalSolution.get(indexOfSolution).get(indexOfElement) == arrayOfSolutions[i][1]
                    ) {
                        List<Integer> extendedSolution = new ArrayList<>();
                        extendedSolution.addAll(globalSolution.get(indexOfSolution)); // make a copy of the solution
                        
                        concatenateSolutions(extendedSolution, indexOfElement, arrayOfSolutions[i]); // concatenate to the solution

                        globalSolution.add(extendedSolution); // Add the extended solution
                        
                        usedSolutions[i] = true;
                        continue;
                }
            }

        }

        deleteAllSolutionsWithLengthUnderX(globalSolution, indexOfElement + 2);

        return false;
    }

    public boolean doesPreImageExists(int[] A) {
        List<List<Integer>> globalSolutions = new ArrayList<>() { { add(new ArrayList<Integer>()); } };

        for (int i = 0; i < A.length; i++) {
            if (i == A.length - 1) {
                return checkForOverlapAndConcat(globalSolutions, i, A.length, solutions0);
            }
            if (A[i] == 0) {

                checkForOverlapAndConcat(globalSolutions, i, A.length, solutions0);
                
            } else { // A[i] == 1

                checkForOverlapAndConcat(globalSolutions, i, A.length, solutions1);

            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 1, 1, 0};

        System.out.println(new EvolutionOfArray().doesPreImageExists(A));
    }
}