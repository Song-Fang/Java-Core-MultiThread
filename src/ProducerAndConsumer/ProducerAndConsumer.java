package ProducerAndConsumer;

public class ProducerAndConsumer {
    public static void main(String [] args){
        Product product = new Product();
        Consumer consumer = new Consumer(product);
        Productor productor = new Productor(product);
        new Thread(productor).start();
        new Thread(consumer).start();

    }
}

class Product{
    private int product;

    public Product(){

    }

    public synchronized void produce(){
        while(true){
            if(product<20){
                System.out.println("Producer begins to produce products:"+ product);
                product++;
                notify();
            }else{
                try{
                    wait();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }

    public synchronized void consume(){
        while(true){

            if(product>0){
                System.out.println("Consumer begins to consume products:"+ product);
                product--;
                notify();
            }else{
                try{
                    wait();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        }
    }
}

class Consumer implements Runnable{
    private Product product;

    public Consumer(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        product.consume();
    }
}

class Productor implements Runnable{
    private Product product;

    public Productor(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        product.produce();
    }
}
