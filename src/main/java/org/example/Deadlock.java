package org.example;

public class Deadlock implements Runnable{
    private X x=new X();
    private Q q=new Q();
    public Deadlock(){
        new Thread(this).start();
        q.say(x);
    }
    @Override
    public void run() {

        x.say(q);
    }


}
class  Q{
    public synchronized void say(X x){
        System.out.println("开路给钱");
        x.get();
    }
    public synchronized void get(){
        System.out.println("我要钱");
    }

}
class X{
    public synchronized void say(Q q){
        System.out.println("先过后钱");
        q.get();
    }
    public   void get(){
        System.out.println("我要过");
    }
}

