package Lambda;


public class LambdaImp {
    interface interf{
        void m1();
    }
    static class interfimp implements interf{
        @Override
        public void m1(){
            System.out.println("Hello");
        }
    }

    public static void main(String[] args) {
        interf i1 = new interfimp();
        i1.m1();
        interf i = () -> {
            System.out.println("Hello");
        };
        i.m1();
    }
}
