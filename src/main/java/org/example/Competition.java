package org.example;

import java.util.concurrent.Callable;

public class Competition implements Callable<String> {
    private boolean flag=true;
    @Override
    public String call() throws Exception {
        synchronized (this){
            if (this.flag==true){
                this.flag=false;
                return Thread.currentThread().getName()+"抢答成功";
            }else {
                return Thread.currentThread().getName()+"抢答失败";
            }
        }
    }
}
