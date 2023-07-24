package Interfaces;

public class PocoF3 implements Phone {

    @Override
    public String process() {
        return "PocoF3";
    }

    @Override
    public String OS() {
        return "MIUI14";
    }

    @Override
    public int Space() {
        return 128;
    }
}
