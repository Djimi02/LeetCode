public class MergeSortedArray {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        for (int i = m; i < nums1.length; i++) { // add all numbers in nums2 to nums1
            nums1[i] = nums2[i-m];
        }

        // sort nums1
        

    }


    public static void main(String[] args) {
        
    }
}
