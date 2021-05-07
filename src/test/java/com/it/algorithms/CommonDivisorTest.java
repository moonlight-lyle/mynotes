package com.it.algorithms;

import org.junit.Test;

/**
 * 求最大公约数
 *
 * @author Lyle
 * @date 2021/5/7
 */
public class CommonDivisorTest {

    @Test
    public void getCommonDivisor(){
        System.out.println(gcd(30, 12));
    }

    public int gcd(int p,int q){
        if (q==0){
            return p;
        }else {
           int r=p%q;
           return gcd(q,r);
        }
    }
}
