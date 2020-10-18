package bsu.rfe.java.group10.lab1.Charnetskyvladymir.varC2;

public class Cocktail extends Food{
    private String drink = null;
    private String fruit = null;
    private Double calories = null;


    public Cocktail(String drink, String fruit){
        super ("Коктейль");
        this.drink = drink;
        this.fruit = fruit;
    }

    public void consume(){
        System.out.println(this + " напиток " + this.drink +" с фруктом " + this.fruit + " выпит ");
    }

    public String getFillings(){
        return (drink + " и " + fruit);  // Так можно делать ?
    }

    public void setFillings(String drink, String fruit){
        this.drink = drink;
        this.fruit = fruit;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Cocktail)) return false;
            return (drink.equals(((Cocktail)arg0).drink) && fruit.equals(((Cocktail)arg0).fruit) ); // Один & или && Ответ получен
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " напиток " + this.drink + " с фруктом " + this.drink;
    }

    public Double calculateCalories(){
        if(drink.equals("Молочный") && fruit.equals("Клубникой")){
            calories = 7.0 + 3.0;
        } else if (drink.equals("Шоколадный") && fruit.equals("Карамелью")){
            calories = 9.0 + 4.0;
        } else if (drink.equals("Тэкила") && fruit.equals("Солью")){
            calories = 9.0 + 4.0;
        }
        return calories;
}
}
