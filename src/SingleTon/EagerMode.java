package SingleTon;

public class EagerMode {
    private static EagerMode eagerMode = new EagerMode();

    private EagerMode(){

    }

    public static EagerMode getInstance(){
        return eagerMode;
    }

}
