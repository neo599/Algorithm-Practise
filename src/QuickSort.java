/**
 * Created by congrenhan on 11/9/16.
 */
import java.util.*;

class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{2,8,7,1,3,5,6,4};
        quickSort(nums, 0, nums.length);

        System.out.println("final result: " + Arrays.toString(nums));
    }

    public static void quickSort(int[]nums, int start, int end) {
        if (start < end) {
            int pivotPos = partition(nums, start, end);

            quickSort(nums, start, pivotPos - 1);
            quickSort(nums, pivotPos + 1, end);
        }
    }

    public static int partition(int[]nums, int left, int right) {
        int pivot = left;
        if (left < right) {
            int pivotNum = nums[left];

            for (int i = left; i < right; i++) {
                if (i > pivot && nums[i] < pivotNum) {
                    pivot++;
                    swap(nums, pivot, i);
                    i--;
                }
            }
            swap(nums, pivot, left);
        }
        System.out.println(Arrays.toString(nums));
        return pivot;
    }

    public static void swap(int[]nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}
