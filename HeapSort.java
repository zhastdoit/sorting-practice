// Time: O(log(n))

public class HeapSort {
    private void sort(int[] nums) { 
        int n = nums.length; 
  
        // Build heap 
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);  
        }
  
        // One by one extract an element from heap 
        for (int i = n - 1; i > 0; i--) { 
            // Move current root to end 
            int temp = nums[0]; 
            nums[0] = nums[i]; 
            nums[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(nums, i, 0); 
        } 
    } 
  
    // To heapify a subtree rooted with node i which is 
    // an index in nums[]. n is size of heap 
    void heapify(int[] nums, int n, int i) { 
        int largest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && nums[l] > nums[largest]) {
            largest = l; 
        }
  
        // If right child is larger than largest so far 
        if (r < n && nums[r] > nums[largest]) {
            largest = r; 
        }
  
        // If largest is not root 
        if (largest != i) { 
            swap(nums, i, largest);
  
            // Recursively heapify the affected sub-tree 
            heapify(nums, n, largest); 
        } 
    } 

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int nums[] = {1, 2, 3, 5, 6, 7, 8, 2, 3, 5};
        System.out.print("Old: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        hs.sort(nums);
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