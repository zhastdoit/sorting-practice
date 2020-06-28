// Time: Best Ω(n+k) Average Θ(n+k) Worst O(n^2)    
// Space: O(n)

public class BucketSort {

    private void bucketSort(char[] chars) {
        int count[] = new int[256];
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
        BucketSort bs = new BucketSort();
        char chars[] = {'a', 'b', 'e', 'c', ':', ')'};
        System.out.print("Old: ");
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
        bs.bucketSort(chars);
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