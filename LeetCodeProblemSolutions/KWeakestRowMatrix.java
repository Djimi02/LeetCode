
public class KWeakestRowMatrix {

    public int[] findNumberOfSoldiers(int[][] mat){
        int[] numOfSoldiers = new int[mat.length];
        int soldierCounter = 0;

        for (int i = 0; i < mat.length; i++) {
            soldierCounter = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                if (mat[i][j] == 1) {
                    soldierCounter++;
                }
            }
            numOfSoldiers[i] = soldierCounter;
        }

        return numOfSoldiers;
    }
    
    public int[] kWeakestRows(int[][] mat, int k) {
        int numOfSoldiers[] = findNumberOfSoldiers(mat);
        int output[] = new int[k];
        int currentMin = numOfSoldiers[0];
        int indexOfMin = 0;

        for (int i = 0; i < k; i++) {
            indexOfMin = 0;
            currentMin = numOfSoldiers[0];
            for (int j = 1; j < numOfSoldiers.length; j++) {
                if (currentMin > numOfSoldiers[j]){
                    currentMin = numOfSoldiers[j];
                    indexOfMin = j;
                }
            }
            output[i] = indexOfMin;
            numOfSoldiers[indexOfMin] = 100;
        }

        return output;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,0,0,0},
        {1,1,1,1},
        {1,0,0,0},
        {1,0,0,0}};

        int[] output = new KWeakestRowMatrix().kWeakestRows(mat, 2);

        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }

    }
}
