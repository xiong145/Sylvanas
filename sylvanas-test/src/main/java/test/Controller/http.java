package test.Controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class http {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            http htt=new http();
            htt.fun();
        }
    }


    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void fun() {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(HttpUtil.get("https://b23.tv/WEfSOOd"));
                while (true) {
                    HttpRequest.get("https://b23.tv/WEfSOOd");
                }
            }
        });
    }


}
