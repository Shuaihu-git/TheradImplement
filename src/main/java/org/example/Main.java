package org.example;

import java.awt.*;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {
    public static boolean flag=true;
    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread());
        new MyThraed("线程1").start();
        new MyThraed("线程2").start();
        new MyThraed("线程3").start();

        for (int x = 0; x < 3; x++) {
            String title = "线程" + x;
            new Thread(() -> {
                for (int y = 0; y < 10; y++) {
                    System.out.println(title + "y=" + y);
                }
            }
            ).start();
        }
        Ticket ticket = new Ticket();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();


        FutureTask<String> futureTask = new FutureTask<>(() -> {
            int numticket = 9;
            if (numticket > 0) {
                for (int x = 0; x < 9; x++) {
                    System.out.println("Callable卖票" + numticket--);
                }
            }
            return "执行成功";
        });
        String string = null;
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
        NameThread nameThread=new NameThread();
        new Thread(nameThread,"1").start();
        new Thread(nameThread,"3").start();
        new Thread(nameThread,"2").start();
        nameThread.run();
        Callable<Integer> callable=new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int return1=0;
                for (int x=0;x<10;x++){
                    return1+=x;
                }
                return return1;
            }
        };
        FutureTask<Integer> integerFutureTask=new FutureTask<>(callable);
        new Thread(integerFutureTask).start();
        System.out.println(integerFutureTask.get());

        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                    for (int y=0;y<8;y++){
                        System.out.println(Thread.currentThread().getName()+"y="+y);

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    }


        };
                for (int x=0;x<5;x++){
                new Thread(runnable,"线程序号="+x).start();
                }

        Thread thread=new Thread(()->{
            System.out.println("休眠开始");
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                System.out.println("休眠被中断");
                e.printStackTrace();

            }
        });
                thread.start();
                thread.sleep(2000);
                if (!(thread.isInterrupted())){
                    thread.interrupt();
                    System.out.println("非正常休眠");

                }
                Thread main =Thread.currentThread();
                System.out.println(main);

               Thread thread1=new Thread(()->{
                   for (int x=0;x<10;x++){
//                       if (x==2){
//                           try {
//                               main.join();
//                           } catch (InterruptedException e) {
//                               throw new RuntimeException(e);
//                           }
//                       }
//                       if (x%2==0){
//                           Thread.yield();
//                       }
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                       System.out.println("["+Thread.currentThread().getName()+"]"+"x="+x);
                   }
               },"调用线程");
               thread1.start();
               for (int x=0;x<100;x++){
                   if (x%2==0){
                       main.yield();
                       main.sleep(2000);
                   }
                   main.sleep(100);
                   System.out.println("[主线程]x="+x);
               }
               System.out.println(Thread.currentThread().getPriority());
               System.out.println(main.currentThread().getPriority());
               System.out.println(thread.currentThread().getPriority());
               Ticket ticket1=new Ticket();
               new Thread(ticket1,"A线程").start();
               new Thread(ticket1,"B线程").start();
               new Thread(ticket1,"C线程").start();
               System.out.println("synchronized");
               System.out.println("synchronized");
               System.out.println("synchronized");
               Deadlock deadlock=new Deadlock();
               Message message=new Message();
               new Thread(new Producter(message)).start();
               new Thread(new Consumer(message)).start();
               new Thread(()->{
                   int num=1;
                   while (flag){
                       try {
                           Thread.sleep(20);
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                       System.out.println(Thread.currentThread().getName()+num++);
                   }
               },"执行线程").start();
               Thread.sleep(100);
               flag=false;
               Thread nomthread=new Thread(()->{
                   for (int i = 0; i < 10; i++) {
                       try {
                           Thread.sleep(100);
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                       System.out.println(Thread.currentThread().getName()+"x="+i);
                   }
               },"nom");
                Thread daemonthread=new Thread(()->{
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(Thread.currentThread().getName()+"x="+i);
                    }
                },"daemon");
                daemonthread.setDaemon(true);
                nomthread.start();
                daemonthread.start();
        Resource resource=new Resource();
        new Thread(new ConsumerNum(resource),"加法线程_A").start();
        new Thread(new ConsumerNum(resource),"加法线程_B").start();
        new Thread(new ProducterNum(resource),"减法线程_x").start();
        new Thread(new ProducterNum(resource),"减法线程_Y").start();
        Computer computer=new Computer();
            ComputerResource computerResource=new ComputerResource(computer);
            ProducterCom producterCom=new ProducterCom(computerResource);
            boolean flag=true;
            while (flag){
                new Thread(producterCom,"生产线程").start();
                new Thread(new ConsumerCom(computerResource),"消费线程").start();
                flag=false;
            }

            Thread threadt=new Thread(()->{
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("生产电脑总数："+ Computer.num +"台");
            });
                threadt.start();
                Competition competition=new Competition();
                FutureTask<String> futureTaskA=new FutureTask<>(competition);
                FutureTask<String> futureTaskB=new FutureTask<>(competition);
                FutureTask<String> futureTaskC=new FutureTask<>(competition);
                new Thread(futureTaskA,"抢答者A").start();
                new Thread(futureTaskB,"抢答者B").start();
                new Thread(futureTaskC,"抢答者C").start();
                System.out.println(futureTaskA.get());
                System.out.println(futureTaskB.get());
                System.out.println(futureTaskC.get());
                System.out.println("------------");







    }
}