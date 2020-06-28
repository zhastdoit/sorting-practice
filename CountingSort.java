// Time: Best Ω(n+k) Average Θ(n+k) Worst O(n+k)     
// Space: O(k)

public class CountingSort {

    public void sort(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];

        int max = arr[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] count = new int[max + 1];

        for (int num : arr) {
            count[num]++;
        }

        //**** Core ****
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int num : arr) {
            int pos = count[num] - 1;
            arr[pos] = num;
            count[num]--;
        }
        //**************
    }

    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        int[] nums = new int[]{1, 2, 3, 2, 3, 2, 5, 6, 7, 8, 0};
        System.out.print("Old: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        cs.sort(nums);
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