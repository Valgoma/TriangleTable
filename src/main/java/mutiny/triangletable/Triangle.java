package mutiny.triangletable;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Triangle {
    SimpleIntegerProperty a;
    SimpleIntegerProperty b;
    SimpleIntegerProperty c;

    public int getA() {
        return a.get();
    }

    public SimpleIntegerProperty aProperty() {
        return a;
    }

    public void setA(int a) {
        this.a.set(a);
    }

    public int getB() {
        return b.get();
    }

    public SimpleIntegerProperty bProperty() {
        return b;
    }

    public void setB(int b) {
        this.b.set(b);
    }

    public int getC() {
        return c.get();
    }

    public SimpleIntegerProperty cProperty() {
        return c;
    }

    public void setC(int c) {
        this.c.set(c);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public Triangle(int a, int b, int c) {
        this.a = new SimpleIntegerProperty(a);
        this.b = new SimpleIntegerProperty(b);
        this.c = new SimpleIntegerProperty(c);

        this.a.addListener((val, oldval, newval)-> System.out.println("изменилось "+oldval+" стало "+newval));
        this.b.addListener((val, oldval, newval)-> System.out.println("изменилось "+oldval+" стало "+newval));
        this.c.addListener((val, oldval, newval)-> System.out.println("изменилось "+oldval+" стало "+newval));
    }

}
