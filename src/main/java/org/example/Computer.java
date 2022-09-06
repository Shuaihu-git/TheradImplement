package org.example;

public class Computer {
    public static int num=0;



    public synchronized int getNum() {
        return num;
    }
}
