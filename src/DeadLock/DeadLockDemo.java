package DeadLock;

public class DeadLockDemo {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer();
        StringBuffer b = new StringBuffer();

        new Thread(){
            @Override
            public void run(){
                try{
                    synchronized (a){
                        a.append("ab");

                        Thread.sleep(2000);

                        synchronized (b){
                            b.append("12");
                    }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                try{
                    synchronized (b){
                        a.append("cd");

                        Thread.sleep(2000);

                        synchronized (a){
                            b.append("34");
                        }
                    }
                    System.out.println(a);
                    System.out.println(b);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();



    }
}
