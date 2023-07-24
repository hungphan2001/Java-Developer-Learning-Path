package Abstract;

public abstract class Person implements IsAlive,LiveLife {
    public void speak(){
        System.out.print("Share hiss/her thoughs");
    }

    @Override
    public void breathe() {
        System.out.println("Be alive");
    }

    @Override
    public void message() {
        System.out.println("Life is journey,kee moving ");
    }
    public abstract void eat();
}
