package org.wl.secondSection;


import org.wl.secondSection.sortTemplate.Example;

/*
选择排序：
    首先，找到数组中最小的那个元素，其次，将它和数组的第 一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。
    再次，在剩下的元素中 找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。
    这种方法 叫做选择排序，因为它在不断地选择剩余元素之中的最小者。
*/
public class _010_Selection {

    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (Example.less(a[j], a[min])) {
                    min = j;
                }
            }
            Example.exec(a, i, min);
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{"b","s","d","a","j"};
        sort(a);
        assert Example.isSorted(a);
        Example.show(a);
    }
}
