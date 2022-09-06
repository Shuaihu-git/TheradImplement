package org.example;

public class ComputerResource {
    private Computer computer;

    private boolean change=true;
    public ComputerResource(Computer computer){
        this.computer=computer;
    }

    public synchronized String set(){
        if (this.change==false){
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
        this.change=false;
        this.computer.num++;
        super.notify();
        return Thread.currentThread().getName()+"生产电脑";
    }
    public synchronized String get(){
        if (this.change==true){
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
        this.change=true;
        super.notify();
        return Thread.currentThread().getName()+"列装电脑";
    }

}
