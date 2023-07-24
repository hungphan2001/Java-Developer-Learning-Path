package SeriallizationOfObjects;

import java.io.Serial;
import java.io.Serializable;

public class Vehicle implements Serializable {
    @Serial
    private static final long serialVersionUID = -1461272870039594921L;
    private String type;
    private int number;

    public Vehicle(String type, int number) {
        this.type = type;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", number=" + number +
                '}';
    }
}
