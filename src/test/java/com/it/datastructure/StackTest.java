package com.it.datastructure;

import com.it.data_structure.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
