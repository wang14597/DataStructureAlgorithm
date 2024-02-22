package org.wl.JavaConcurrency;

import java.util.concurrent.FutureTask;

// FutureTask实现异步任务：通过get获取线程执行结果
public class _008_Preloader {

    public static class ProductInfo{}

    private final FutureTask<ProductInfo> futureTask = new FutureTask<>(this::loadProductInfo);

    private final Thread thread = new Thread(futureTask);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws Exception{
        return futureTask.get();
    }

    private ProductInfo loadProductInfo() throws InterruptedException {
        Thread.sleep(10000);
        return new ProductInfo();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("-----------");
        _008_Preloader preloader = new _008_Preloader();
        preloader.start();
        System.out.println("-----------");
        ProductInfo productInfo = preloader.get();
        System.out.println(productInfo);

    }
}
