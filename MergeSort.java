// Time: Best O(n log(n)) Average O(n log(n)) Worst O(n log(n))
// Space: O(n)

public class MergeSort {

    private void merge(int[] nums, int l, int m, int r) { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = nums[l + i]; 
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = nums[m + 1 + j]; 
        }
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                nums[k] = L[i]; 
                i++; 
            } 
            else { 
                nums[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) { 
            nums[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) { 
            nums[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 

    private void sort(int[] nums, int l, int r) {
        if (l < r) { 
            // Find the middle point 
            int m = (l + r) / 2; 
  
            // Sort first and second halves 
            sort(nums, l, m); 
            sort(nums, m + 1, r); 
  
            // Merge the sorted halves 
            merge(nums, l, m, r); 
        } 
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int nums[] = {1, 2, 3, 5, 6, 7, 8, 2, 3, 5};
        System.out.print("Old: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        ms.sort(nums, 0, nums.length - 1);
        System.out.println();
        System.out.print("New: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}