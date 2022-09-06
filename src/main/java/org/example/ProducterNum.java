package org.example;

public class ProducterNum implements Runnable{
    private Resource resource;
    public ProducterNum(Resource resource){
        this.resource=resource;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.resource.sub();
        }

    }
}
