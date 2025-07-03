//A: Split Array Largest Sum Problem:
//B: Painter's Partition

import java.util.ArrayList;
import java.util.Collections;

public class S {

    //Approach-1: Brute Force
    //TC = O(N * (sum(arr[]) - max(a[]) + 1)), SC = O(1)
    //A
    public static int countPartitions1(int[] a, int maxSum) {
        int n = a.length;
        int partitions = 1;
        long subarraySum = 0;
        for (int i = 0; i < n; i++) {
            if (subarraySum + a[i] <= maxSum) {
                subarraySum += a[i];
            } else {
                partitions++;
                subarraySum = a[i];
            }
        }
        return partitions;
    }

    public static int largestSubarraySumMinimized1(int[] a, int k) {
        int low = a[0];
        int high = 0;

        for (int i = 0; i < a.length; i++) {
            low = Math.max(low, a[i]);
            high += a[i];
        }

        for (int maxSum = low; maxSum <= high; maxSum++) {
            if (countPartitions1(a, maxSum) == k) {
                return maxSum;
            }
        }
        return low;
    }

    //B
    public static int countPainters1(ArrayList<Integer> boards, int time) {
        int n = boards.size(); // size of array.
        int painters = 1;
        long boardsPainter = 0;
        for (int i = 0; i < n; i++) {
            if (boardsPainter + boards.get(i) <= time) {
                // allocate board to current painter
                boardsPainter += boards.get(i);
            } else {
                // allocate board to next painter
                painters++;
                boardsPainter = boards.get(i);
            }
        }
        return painters;
    }

    public static int findLargestMinDistance1(ArrayList<Integer> boards, int k) {
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        for (int time = low; time <= high; time++) {
            if (countPainters1(boards, time) <= k) {
                return time;
            }
        }
        return low;
    }

    //Approach-2: Binary Search
    //TC = O(N * log(sum(arr[]) - max(arr[]) + 1)), SC = O(1)
    //A
    public static int countPartitions2(int[] a, int maxSum) {
        int n = a.length; //size of array.
        int partitions = 1;
        long subarraySum = 0;
        for (int i = 0; i < n; i++) {
            if (subarraySum + a[i] <= maxSum) {
                //insert element to current subarray
                subarraySum += a[i];
            } else {
                //insert element to next subarray
                partitions++;
                subarraySum = a[i];
            }
        }
        return partitions;
    }

    public static int largestSubarraySumMinimized2(int[] a, int k) {
        int low = a[0];
        int high = 0;
        //find maximum and summation:
        for (int i = 0; i < a.length; i++) {
            low = Math.max(low, a[i]);
            high += a[i];
        }

        //Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = countPartitions2(a, mid);
            if (partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    //B
    public static int countPainters2(ArrayList<Integer> boards, int time) {
        int n = boards.size(); // size of array.
        int painters = 1;
        long boardsPainter = 0;
        for (int i = 0; i < n; i++) {
            if (boardsPainter + boards.get(i) <= time) {
                // allocate board to current painter
                boardsPainter += boards.get(i);
            } else {
                // allocate board to next painter
                painters++;
                boardsPainter = boards.get(i);
            }
        }
        return painters;
    }

    public static int findLargestMinDistance2(ArrayList<Integer> boards, int k) {
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        // Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int painters = countPainters2(boards, mid);
            if (painters > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
