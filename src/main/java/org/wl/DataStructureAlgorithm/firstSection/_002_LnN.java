package org.wl.DataStructureAlgorithm.firstSection;
/*
* 编写一个递归的静态方法计算 ln(N!) 的值
*/
public class _002_LnN {

    public static void main(String[] args) {
        System.out.println(_002_LnN.lnN(20));
    }

    private static double lnN(int i) {
        if (i == 1) {
            return Math.log(1);
        }
        return Math.log(i) + lnN(i - 1);
    }
}
