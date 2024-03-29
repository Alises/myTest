package com.example.demo.leetcode.simple;

/**
 * 2019/11/14 create by Gq
 * 罗马数字转整数
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 * <p>
 * 示例1:
 * <p>
 * 输入:"III"
 * 输出: 3
 * 示例2:
 * <p>
 * 输入:"IV"
 * 输出: 4
 * 示例3:
 * <p>
 * 输入:"IX"
 * 输出: 9
 * 示例4:
 * <p>
 * 输入:"LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例5:
 * <p>
 * 输入:"MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */

public class RomanToIntTest {

    public static void main(String[] args) {
        String romanNum = "III";
        System.out.println(romanToInt(romanNum));
    }

    public static int romanToInt(String s) {
        int[] value = {1, 5, 10, 50, 100, 500, 1000};
        String romans = "IVXLCDM";
        int result = 0;
        int preValue = 0;

        for (int i = s.length() - 1; i > -1; i--) {
            char pop = s.charAt(i);
            int popValue = value[romans.indexOf(pop)];
            if (popValue >= preValue) {
                result += popValue;
            } else {
                result -= popValue;
            }
            preValue = popValue;
        }

        return result;
    }
}
