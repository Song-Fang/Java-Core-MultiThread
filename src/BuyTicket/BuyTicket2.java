package BuyTicket;

public class BuyTicket2 {
    public static void main(String [] args){
        TicketDemo2 ticketDemo2 = new TicketDemo2();
        for(int i =0;i<3;i++){
            new Thread(ticketDemo2).start();
        }
    }
}

class TicketDemo2 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }

        while(true){
            /*synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }*/
            if(sellTicket()){
             continue;
            }

            break;
        }

    }

    private synchronized boolean sellTicket(){
        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+":"+ticket);
            ticket--;
            return true;
        }else{
            return false;
        }
    }
}
