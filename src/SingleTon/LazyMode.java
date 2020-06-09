package SingleTon;

public class LazyMode {
    private static LazyMode lazyMode1;

    private LazyMode(){

    }

    //The efficiency is not good
    public static synchronized LazyMode getInstance(){
        if(lazyMode1==null){
            lazyMode1 = new LazyMode();
            return lazyMode1;
        }
        return lazyMode1;
    }
}
