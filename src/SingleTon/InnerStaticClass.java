package SingleTon;

public class InnerStaticClass {
    private static class InnerClassHolder{
        public static InnerStaticClass innerStaticClass = new InnerStaticClass();
    }

    private InnerStaticClass(){

    }

    public static InnerStaticClass getInstance(){
        return InnerClassHolder.innerStaticClass;
    }
}
