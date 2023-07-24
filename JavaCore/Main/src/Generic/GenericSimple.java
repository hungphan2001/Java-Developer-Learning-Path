package Generic;

public class GenericSimple {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.setContent(10);
        int content1 = integerBox.getContent();

        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello");
        String content2 = stringBox.getContent();
    }
}
