package AtomicDemo;

import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String [] args){
        AtomicTest atomicTest = new AtomicTest();
        for(int i =0;i<10;i++) {
            new Thread(atomicTest).start();
        }
    }
}

class AtomicTest implements Runnable{
    private AtomicInteger tag =new AtomicInteger(0);

    @Override
    public void run() {
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(tag.getAndIncrement());

    }
}
