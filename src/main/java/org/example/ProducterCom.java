package org.example;

public class ProducterCom implements Runnable{
    private ComputerResource computerResource;
    public ProducterCom(ComputerResource computerResource){
        this.computerResource=computerResource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 40; i++) {
            System.out.println(this.computerResource.set());
        }
    }

}
