package org.example;

public class ConsumerNum implements Runnable {
    private Resource resource;
    public ConsumerNum(Resource resource){
        this.resource=resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.resource.add();
        }

    }
}
