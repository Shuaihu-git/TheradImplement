package org.example;

import java.util.concurrent.Callable;

public class CallImp implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int x=0;x<10;x++){
            System.out.println("线程执行：x="+x);
        }
        return "执行完毕。";
    }
}
