package org.example;

public class ConsumerCom implements Runnable{
    private ComputerResource computerResource;
    public ConsumerCom(ComputerResource computerResource){
        this.computerResource=computerResource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 40; i++) {
            System.out.println(this.computerResource.get());
        }
    }
}
