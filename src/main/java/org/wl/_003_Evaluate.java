package org.wl;

import java.util.ArrayList;

/*
算术表达式求值算法
输入的表达式必须在（）内，且每个完整的数字或操作符用空格分割
 */
public class _003_Evaluate {

    public static class Stack {
        private final ArrayList<String> arrayList = new ArrayList<>();
        private int count = 0;

        public synchronized String pop() {
            return arrayList.remove(--count);
        }

        public synchronized void push(String s) {
            count++;
            arrayList.add(s);
        }
    }

    public static void main(String[] args) {
        System.out.println(_003_Evaluate.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )".split(" ")));
    }

    private static String evaluate(String[] s) {
        Stack stack = new Stack();
        for (String value : s) {
            if (")".equals(value)) {
                String v1 = stack.pop();
                String v2 = stack.pop();
                String v3 = stack.pop();
                stack.push(Double.toString(calculateResult(v1, v2, v3)));
            } else {
                if (!"(".equals(value)) {
                    stack.push(value);
                }
            }
        }

        return stack.pop();
    }

    private static double calculateResult(String v1, String v2, String v3) {
        double parseDouble1 = Double.parseDouble(v1);
        double parseDouble2 = Double.parseDouble(v3);
        switch (v2) {
            case "+":
                return parseDouble1 + parseDouble2;
            case "-":
                return parseDouble1 - parseDouble2;
            case "*":
                return parseDouble1 * parseDouble2;
            default:
                return parseDouble1 / parseDouble2;
        }
    }
}
