package StaticVariable;

public class Main {
    public static void main(String[] args) {
     TestStatic obj1 = new TestStatic();
     System.out.println("Obj var "+TestStatic.getStaticVariable());
     obj1.setStaticVariable(5);
     System.out.println("Obj var "+TestStatic.getStaticVariable());
    }
}
