package Enum;

public class Demo {
    public static void main(String[] args) {
        Learning learning = Learning.COREJAVA;

        switch (learning) {
            case COLLECTIONS:
                System.out.println("Step 2 : Learn Collection");
                break;
            case COREJAVA:
                System.out.println("Step 1 : Learn Core Java");
                break;
            case GENERICS:
                break;
            case JSPANSERVLETS:
                break;
            case MUILTIHREADING:
                break;
        }
    }
}
