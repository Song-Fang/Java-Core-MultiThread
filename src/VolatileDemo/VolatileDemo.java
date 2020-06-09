package VolatileDemo;

public class VolatileDemo {
    public static void main(String [] args){
        TestVolatile testVolatile = new TestVolatile();
        new Thread(testVolatile).start();
        while(true){
            if(testVolatile.getFlag()){
                System.out.println("I am out!");
                break;
            }

        }
    }
}

class TestVolatile implements Runnable{
    private volatile boolean flag = false;

    public boolean getFlag(){
        return flag;
    }



    @Override
    public void run() {
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        this.flag = true;
        System.out.println("Flag has been set true!");
    }
}
