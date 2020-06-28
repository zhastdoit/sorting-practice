// Time: Best Ω(nlog(n)) Average Θ(nlog(n)) Worst O(n^2) * Not in place sort!!
// Space: O(log(n))

public class QuickSort {

    private int partition(int[] nums, int l, int r) {     
        int pivot = nums[r];  
        int i = (l - 1);
        for (int j = l; j < r; j++) { 
            // If current element is smaller than the pivot 
            if (nums[j] < pivot) { 
                i++; 
                swap(nums, i, j);
            } 
        } 
  
        swap(nums, i + 1, r);
  
        return i + 1; 
    } 
    private void sort(int[] nums, int l, int r) {
        if (l < r) { 
            int idx = partition(nums, l, r);
            sort(nums, l, idx - 1);
            sort(nums, idx + 1, r); 
        } 
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int nums[] = {1, 2, 3, 5, 6, 7, 8, 2, 3, 5};
        System.out.print("Old: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        qs.sort(nums, 0, nums.length - 1);
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