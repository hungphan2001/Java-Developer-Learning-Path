package StaticVariable;

public class TestStatic {
    private static int a = 0;
    public static int getStaticVariable (){
        return a;
    }

    public static void setStaticVariable(int a){
        TestStatic.a=a;
    }
}
