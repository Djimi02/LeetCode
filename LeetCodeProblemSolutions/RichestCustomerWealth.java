public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int i = 0; i < accounts.length; i++) {
            int custWealth = 0;

            for (int j = 0; j < accounts[i].length; j++) {
                custWealth += accounts[i][j];
            }

            if (maxWealth < custWealth) {
                maxWealth = custWealth;
            }
        }

        return maxWealth;
    }   

    public static void main(String[] args) {
        int[][] accounts = {{1,2,3},{3,2,3}};

        System.out.println(new RichestCustomerWealth().maximumWealth(accounts));
    }
}
