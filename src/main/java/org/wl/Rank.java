package org.wl;

/*
递归二分查找
 */
public class Rank {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7};
        System.out.println(Rank.rank(70,numbers));
    }

    private static int rank(int key, int[] numbers) {
        return rank(key, numbers, 0, numbers.length-1);
    }

    private static int rank(int key, int[] numbers, int start, int end) {
        // [0,1,2,3,4,5,6]  key = 4
        // mid = 3 < 4 start=3,end=6 [3,4,5,6]
        // mid = start + (end - start) / 2
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (numbers[mid] > key) {
            return rank(key, numbers, start, mid - 1);
        } else if (numbers[mid] < key) {
            return rank(key, numbers, mid + 1, end);
        }else {
            return mid;
        }
    }
}
