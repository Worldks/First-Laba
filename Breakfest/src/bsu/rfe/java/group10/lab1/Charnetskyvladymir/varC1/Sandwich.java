package bsu.rfe.java.group10.lab1.Charnetskyvladymir.varC1;

public class Sandwich extends Food{
    private String Filling_1;
    private String Filling_2;


    public Sandwich (String Filling_1, String Filling_2){
        super ("Сандвич");
        this.Filling_1 = Filling_1;
        this.Filling_2 = Filling_2;
    }

    public void consume(){
        System.out.println(this + "с начинками " + this.Filling_1 +" и " + this.Filling_2 + "съеден");
    }

    public String getFillings(){
       //System.out.println(Filling_1 + " " + Filling_2);
        return (Filling_1 + " и " + Filling_2);  // Так можно делать ?
    }

    public void setFillings(String Filling_1, String Filling_2){
        this.Filling_1 = Filling_1;
        this.Filling_2 = Filling_2;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Sandwich)) return false;
            return (Filling_1.equals(((Sandwich)arg0).Filling_1) && Filling_2.equals(((Sandwich)arg0).Filling_2) ); // Один & или && Ответ получен
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " с начинками  '" + this.Filling_1 + " и " + this.Filling_1;
    }
}