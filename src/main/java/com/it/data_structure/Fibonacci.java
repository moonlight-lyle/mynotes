package com.it.data_structure;

import com.it.util.TimeTool;

/**
 * 斐波那契数列:0，1,1,2,3,5,8,13,21...
 *
 * @author Lyle
 * @date 2021/5/16
 */
public class Fibonacci {
    public static void main(String[] args) {
        // 使用递归方法，n=64就会出现性能问题
//        System.out.println(fib1(64));
        //使用方法二计算n=64时的值
//        System.out.println(fib3(6));
        // 测试方法执行时间
        // 递归方法
        TimeTool.check("fib1", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(fib1(46));
            }
        });
        // 自定义方法二
        TimeTool.check("fib2", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(fib2(46));
            }
        });
    }

    /**
     * 递归求解，性能有问题
     * O(2^n)
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 方法二：
     * O(n)
     * @param n
     * @return
     */
    public static int fib2(int n) {
        // 特殊值保持不变
        if (n == 0 || n == 1) {
            return n;
        }
        // 当n>=2时的计算方法:f(n)=f(n-1)+f(n-2)
        int first = 0; //相当于f(n-2)
        int second = 1; // 相当于f(n-1)
        /**
         * 分析：
         * n=2时：f(2)=f(1)+f(0),只需要循环一次
         * n=3时：f(3)=f(2)+f(1)，f(2)=f(1)+f(0)，需要循环2次
         *  ...
         *  以此类推，需要循环n-1次
         */
        int sum=0;
        for (int i = 0; i < n - 1; i++) {
            sum = first + second;
            // 注意以下2行代码不能换顺序
            first = second; // 原先的second赋值给新的first
            second = sum;//sum赋值给第二次的的second
        }
        return second;

    }

    /**
     * 数学公式计算
     * @param n
     * @return
     */
    public static int fib3(int n) {
        // 特殊值保持不变
       double c=Math.sqrt(5);
       return (int)((Math.pow((1+c)/2,n)-Math.pow((1-c)/2,n))/c);
    }
}
