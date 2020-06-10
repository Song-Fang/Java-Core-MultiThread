package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableCreate {
    public static void main(String [] args) throws Exception{
        CallableDemo callableDemo = new CallableDemo();
        FutureTask futureTask = new FutureTask(callableDemo);
        new Thread(futureTask).start();
        new Thread(futureTask).start();

        System.out.println(futureTask.get());
    }
}

class CallableDemo implements Callable {
    private int sum;

    @Override
    public Object call() throws Exception {

        for(int i =0;i<100;i++){
            synchronized (this){
                if(i%2==0){
                    sum = sum +i;
                }
            }
        }
        return sum;
    }
}
