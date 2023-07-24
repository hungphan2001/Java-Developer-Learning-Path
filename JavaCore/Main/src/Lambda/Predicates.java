package Lambda;

import java.util.function.IntPredicate;

public class Predicates {
    public static void main(String[] args) {
//        IntPredicate moreThan18 = new IntPredicate() {
//            @Override
//            public boolean test(int value) {
//                if(value>18){
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        };
        IntPredicate lesThan18 = i->i<18;
        IntPredicate moreThan10 = i->i>10;
        new Predicates().demo(11,lesThan18,moreThan10);
    }
    public void demo(int x,IntPredicate lessThan18,IntPredicate moreThan10){
        if(lessThan18.and(moreThan10).test(x)){
            System.out.println("the input is lessthan 18 and more than 10 is: "+x);
        } else {
            System.out.println("invalid input");
        }
    }
}
