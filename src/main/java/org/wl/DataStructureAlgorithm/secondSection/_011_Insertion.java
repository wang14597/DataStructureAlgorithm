package org.wl.DataStructureAlgorithm.secondSection;

import org.wl.DataStructureAlgorithm.secondSection.sortTemplate.Example;

/*
* 通常人们整理桥牌的方法是一张一张的来，将每一张牌插入到其他已经有序的牌中的适当位置。
* 在计算机的实现中，为了给要插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移 动一位。这种算法叫做插入排序
*/
public class _011_Insertion {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && Example.less(a[j], a[j - 1]); j--) {
                Example.exec(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{"b","s","d","a","j"};
        sort(a);
        assert Example.isSorted(a);
        Example.show(a);
    }
}
