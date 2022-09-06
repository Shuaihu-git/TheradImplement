package org.example;

public class MyThraed extends Thread{

        private String title;
        public MyThraed(String title){
                this.title=title;
        }
        @Override
        public void run() {
            for (int x=0;x<10;x++){
                    System.out.println(this.title+"执行：x="+x);
            }
        }

}
