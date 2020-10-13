package bsu.rfe.java.group10.lab1.Charnetskyvladymir.varC1;

import java.lang.reflect.Constructor;

public class Main {
        // Конструктор класса отсутствует!!!

        //@SuppressWarnings("unchecked") //Почему он подчеркивает myClass.getConstructor если убрать подавление предупреждений т.е. о чем он меня пытается предупредить?
        public static void main(String[] args) throws Exception {
            Food[] breakfast = new Food[20];
            int itemsSoFar = 0;
            for (String arg: args) {
                String[] parts = arg.split("/");
                try {
                    Class myClass = Class.forName("com.company." + parts[0]);
                    if(parts.length == 1){
                        Constructor constructor = myClass.getConstructor();
                        breakfast[itemsSoFar] = (Food)constructor.newInstance();
                    } else if (parts.length == 2){
                        Constructor constructor = myClass.getConstructor(String.class);
                        breakfast[itemsSoFar] = (Food)constructor.newInstance(parts[1]);
                    } else if (parts.length == 3){
                        Constructor constructor = myClass.getConstructor(String.class, String.class);
                        breakfast[itemsSoFar] = (Food)constructor.newInstance(parts[1], parts[2]);
                    }
                } catch (ClassNotFoundException e){
                        System.out.println(" " + e);
                } catch (NoSuchMethodException ex){
                        System.out.println(" " + ex);
                }
// Перебор всех элементов массива   ПОЕДАНИЕ ЗАВТРАКА
            for (Food item: breakfast)
                if (item!=null)
// Если элемент не null – употребить продукт
                    item.consume();
                else
// Если дошли до элемента null – значит достигли конца
// списка продуктов, ведь 20 элементов в массиве было
// выделено с запасом, и они могут быть не
// использованы все
                    break;
            System.out.println("Всего хорошего!");
             }
        }

        public static void
}