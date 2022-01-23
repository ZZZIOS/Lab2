package ru.spbstu.telematics.java;

import java.util.Iterator;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        Stack<Integer> aaa = new Stack<Integer>();
        MyStack<Integer> bbb = new MyStack<Integer>();
        System.out.println(aaa);
        System.out.println(bbb);
        // try {
        //Object aa = aaa.peek();
        for (int i = 0; i < 10; i++) {
            aaa.push(i);
            bbb.push(i);
        }

        aaa.add(4);

        Iterator<Integer> itt = aaa.iterator();

        for (Integer it : aaa) {
            System.out.println(it);
        }

        while (itt.hasNext()) {
            Integer rr = itt.next();
            System.out.println(rr);
        }

        Iterator<Integer> it = bbb.iterator();

        while (it.hasNext()) {
            Integer rr = it.next();
            System.out.println(rr);
        }

        for (Integer it8 : bbb) {
            System.out.println(it8);
        }


        System.out.println(bbb.search(8));
        System.out.println(aaa.search(8));

        System.out.println(bbb.search(-3));
        System.out.println(aaa.search(-3));

        System.out.println(bbb.search(-1));
        System.out.println(aaa.search(-1));

        System.out.println(bbb.search(10));
        System.out.println(aaa.search(10));


        aaa.pop();
        bbb.pop();
        System.out.println(aaa);
        System.out.println(bbb);


        Iterator<Integer> itb = bbb.iterator();
        bbb.pop();
        System.out.println(bbb.peek());
        bbb.pop();
        System.out.println(bbb.peek());
        bbb.pop();
        System.out.println(bbb.peek());
        bbb.pop();
        System.out.println(bbb.peek());
        bbb.pop();
        System.out.println(bbb.peek());
        bbb.pop();
        System.out.println(bbb.peek());
        bbb.pop();
        System.out.println(bbb.peek());
        bbb.pop();
        System.out.println(bbb.peek());
        bbb.pop();


        while (itb.hasNext()) {
            Integer rr = itb.next();
            System.out.println(rr);
        }

        System.out.println();


    }
}