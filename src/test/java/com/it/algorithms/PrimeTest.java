package com.it.algorithms;

import org.junit.Test;

/**
 * 判断一个数是否为素数
 *
 * @author Lyle
 * @date 2021/5/7
 */
public class PrimeTest {

    @Test
    public void test1() {
        int n = 5;
        System.out.println(isPrime(n));
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else {
            int m = (int) Math.sqrt(n);
            for (int i = 2; i <= m; i++) {
                if (n % m == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
