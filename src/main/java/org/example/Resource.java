package org.example;

public class Resource {
    private int num=0;
    private boolean flag=true;
    public Resource(){
    }
    public synchronized void add(){
        if (this.flag==false){
            try {
                super.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"num="+this.num++);
        this.flag=false;
        super.notifyAll();

    }
    public synchronized void sub(){
        if (this.flag==true){
            try {
                super.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"num="+this.num--);
        this.flag=true;
        super.notifyAll();

    }
    public synchronized int get(){
        return this.num;
    }



}
