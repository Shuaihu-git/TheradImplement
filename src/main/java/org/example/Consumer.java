package org.example;

public class Consumer implements Runnable{
    private Message message;
    public Consumer(Message message){
        this.message=message;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
                System.out.println(this.message.get());
        }
    }
}
