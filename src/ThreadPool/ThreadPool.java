package ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String [] args){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new MyThread());
        executorService.shutdown();
    }
}


class MyThread implements Runnable{

    @Override
    public void run() {
        for(int i =0;i<100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}
