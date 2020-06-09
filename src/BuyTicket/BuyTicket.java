package BuyTicket;

public class BuyTicket {
    public static void main(String [] args){
        for(int i =0;i<3;i++){
            TicketDemo ticketDemo = new TicketDemo();
            ticketDemo.start();
        }
    }
}


class TicketDemo extends Thread{
    private static int ticket=100;
    private static Object object = new Object();
    private static boolean flag = true;

    @Override
    public void run() {
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        while(true){
//            synchronized (object) {
//
//                if (ticket > 0) {
//                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
//                    ticket--;
//                } else {
//                    break;
//                }
//            }
            sellTicket();
        }

    }

    private static synchronized void sellTicket(){

        try{
            Thread.sleep(200);
        }catch(Exception e){
            e.printStackTrace();
        }

        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+":"+ticket);
            ticket--;
        }
    }
}

