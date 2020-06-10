package ReentrantLock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String [] args){
        TicketDemo ticketDemo = new TicketDemo();
        for(int i =0;i<3;i++){
            Thread thread = new Thread(ticketDemo);
            thread.start();
        }
    }
}


class TicketDemo implements Runnable{
    private int ticket = 100;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        while(true){
            lock.lock();
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+":"+ticket);
                ticket--;
            }else{
                break;
            }
            lock.unlock();
        }

    }
}