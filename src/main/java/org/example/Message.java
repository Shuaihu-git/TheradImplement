package org.example;

public class Message {
    private String title;
    private String content;
    private boolean flag=true;

    /**
     * flag
     * true表示可以生产，不能消费
     * false表示可以消费，不能生产
     *
     * @param title
     * @param content
     */
    public synchronized void set(String title,String content){
        if (this.flag==false){
            try {
                super.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.title=title;
        this.content=content;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.flag=false;
        super.notify();
    }
    public synchronized String get(){
        if (this.flag==true){
            try {
                super.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            return this.title+"-->"+this.content;
        }finally {
            this.flag=true;
            super.notify();
        }

    }
}
