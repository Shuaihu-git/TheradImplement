package org.example;

public class Ticket implements Runnable{

    private int ticketnum=100;
    public synchronized boolean sale(){
        if (this.ticketnum>0){
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->" +
                    "开始卖票，票剩余："+this.ticketnum--+"张");
            return true;
        }else {
            System.out.println("票卖完了");
            return false;
        }
    }
    @Override
    public void run() {
        while (this.sale()){
            ;
        }
    }
}
