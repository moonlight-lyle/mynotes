package com.it.algorithms;

import org.junit.Test;

/**
 * 二分查找法
 * 注意二分查找法的数组必须是已经排了序的（按照从大到小排列的）
 * 如果没有排序，请先排序
 * @author Lyle
 * @date 2021/5/7
 */
public class BinarySearchTest {

    @Test
    public void test1(){
        int[] arr={1,3,5,7,9,11,15,18,19,20};
        int target=19;
        System.out.println(binarySearch(arr, target));
    }

    public int binarySearch(int[] arr,int target){
        // 开始索引
        int startIndex=0;
        // 结束索引
        int endIndex=arr.length-1;
        // 循环
        while (startIndex<=endIndex){
            // 中间索引
            int mid=(startIndex+endIndex)/2;
            // 比较目标值和中间索引对应的值，移动开始索引或者结束索引
            if (target==arr[mid]){
                return mid;
            }else if (target>arr[mid]){
                startIndex=mid+1;
            }else {
                endIndex=mid-1;
            }
        }
        return -1;
    }
}
