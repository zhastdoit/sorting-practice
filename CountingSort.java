// Time: Best Ω(n+k) Average Θ(n+k) Worst O(n+k)     
// Space: O(k)

public class CountingSort {

    private void countingSort(char[] chars) {
        int count[] = new int[256];
        // for (int i = 0; i < 256; i++) {
        //     count[i] = 0;
        // }
        for (int i = 0; i < chars.length; i++) {
            count[chars[i]]++;
        }
        int idx = 0;
        for (int i = 0; i < 256; i++) {
            while (count[i] > 0) {
                chars[idx++] = (char)i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        char chars[] = {'a', 'b', 'e', 'c', ':', ')'};
        System.out.print("Old: ");
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
        cs.countingSort(chars);
        System.out.println();
        System.out.print("New: ");
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}