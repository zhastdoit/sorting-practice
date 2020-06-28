// Time: O(nLogn)
import java.util.*; 
public class RadixSort {
    private int getMax(int[] nums, int n) { 
        int mx = nums[0]; 
        for (int i = 1; i < n; i++) {
            if (nums[i] > mx) {
                mx = nums[i]; 
            }
        }
        return mx; 
    } 
  
    private void countSort(int[] nums, int exp) { 
        int[] output = new int[nums.length]; // output array 
        int i; 
        int[] count = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < nums.length; i++) {
            count[(nums[i] / exp) % 10]++; 
        }
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1]; 
        }
  
        // Build the output array 
        for (i = nums.length - 1; i >= 0; i--) { 
            output[count[(nums[i] / exp) % 10] - 1] = nums[i]; 
            count[(nums[i] / exp) % 10 ]--; 
        } 
  
        // Copy the output array to arr[], so that nums[] now contains sorted numbers according to curent digit 
        for (i = 0; i < nums.length; i++) {
            nums[i] = output[i]; 
        }
    } 
  
    private void sort(int[] nums) { 
        // Find the maximum number to know number of digits 
        int m = getMax(nums, nums.length); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(nums, exp); 
        }
    } 

    public static void main(String[] args) {
        RadixSort rs = new RadixSort();
        int nums[] = {1, 2, 3, 5, 6, 7, 8, 2, 3, 5};
        System.out.print("Old: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        rs.sort(nums);
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