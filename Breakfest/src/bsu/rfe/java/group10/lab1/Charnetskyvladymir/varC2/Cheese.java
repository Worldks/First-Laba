package bsu.rfe.java.group10.lab1.Charnetskyvladymir.varC2;

public class Cheese extends Food {
    private Double calories = 10.0;

    public Cheese() {
        super("Сыр");
    }
    public void consume() {
        System.out.println(this + " съеден");
    }
    public Double calculateCalories(){
        return calories;
    }
}
