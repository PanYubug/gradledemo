package com.panyu.jase.threaddemo.futuredemo;

public class Client {
    public Data requset(final String queryStr) {
        final FutureData future = new FutureData();
        new Thread() {
            public void run() {                                 // RealData的构建很慢
                RealData realdata = new RealData(queryStr);     //所以在单独的线程中进行
                future.setRealData(realdata);
            }
        }.start();
        return future;                                          //FutureData会被立即返回
    }
}
