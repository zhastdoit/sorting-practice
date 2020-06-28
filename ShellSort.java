// Time: Best Ω(n^2) Average Θ(n^2) Worst O(n^2)
import java.util.*; 
public class ShellSort {
    private int sort(int[] nums) { 
        int n = nums.length; 
        for (int gap = n / 2; gap > 0; gap /= 2) { 
            for (int i = gap; i < n; i += 1) {
                int temp = nums[i]; 

                int j; 
                for (j = i; j >= gap && nums[j - gap] > temp; j -= gap) {
                    nums[j] = nums[j - gap]; 
                }

                nums[j] = temp; 
            } 
        } 
        return 0; 
    } 

    public static void main(String[] args) {
        ShellSort ss = new ShellSort();
        int nums[] = {1, 2, 3, 5, 6, 7, 8, 2, 3, 5};
        System.out.print("Old: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        ss.sort(nums);
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