package bsu.rfe.java.group10.lab1.Charnetskyvladymir.varC1;

public class Apple extends Food {

    private String size;

    public Apple(String size) {
        super("Яблоко");
        this.size = size;
    }

    public void consume() {
        System.out.println(this + " съедено");
    }

    public Double calculateCalories{

    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Apple)) return false;
            return size.equals(((Apple)arg0).size);
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }
}