package Module2;

public class singleobject {
    private singleobject(){
        System.out.println("Singleobj");
    }
    static final singleobject obj = new singleobject();
    public static singleobject createInstance(){
        return obj;
    }
}
