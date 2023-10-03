package org.wl.DataStructureAlgorithm.secondSection.sortTemplate;

/*排序模版*/
public class Example {

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exec(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void show(Comparable[] a) { // 在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i] + " ");
    }
}
