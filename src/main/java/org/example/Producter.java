package org.example;

public class Producter implements Runnable{
    private Message message;
    public Producter(Message message){
        this.message=message;
    }
    @Override
    public void run() {

            for (int i = 0; i < 100; i++) {
                if (i % 2==0){
                    this.message.set("shuaihu","shuaihu.vip");
                }else {
                    this.message.set("Springboot project","www.shuaihu.vip:8888");

                }

            }

    }
}
