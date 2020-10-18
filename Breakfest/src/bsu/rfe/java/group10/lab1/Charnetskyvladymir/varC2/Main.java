package bsu.rfe.java.group10.lab1.Charnetskyvladymir.varC2;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
        //@SuppressWarnings("unchecked") //Почему он подчеркивает myClass.getConstructor если убрать подавление предупреждений т.е. о чем он меня пытается предупредить?
        public static void main(String[] args) throws Exception {
            Food[] breakfast = new Food[20];
            int itemsSoFar = 0;
            boolean case1, case2; //кейсы для спец параметов(сорт и калории)
            case1 = case2 = false;

            for (String arg : args) {
                String[] parts = arg.split("/");
                try {
                    Class myClass = Class.forName("bsu.rfe.java.group10.lab1.Charnetskyvladymir.varC2." + parts[0]);
                    if (parts.length == 1) {
                        Constructor constructor = myClass.getConstructor();
                        breakfast[itemsSoFar] = (Food) constructor.newInstance();
                        itemsSoFar++;
                    } else if (parts.length == 2) {
                        Constructor constructor = myClass.getConstructor(String.class);
                        breakfast[itemsSoFar] = (Food) constructor.newInstance(parts[1]);
                        itemsSoFar++;
                    } else if (parts.length == 3) {
                        Constructor constructor = myClass.getConstructor(String.class, String.class);
                        breakfast[itemsSoFar] = (Food) constructor.newInstance(parts[1], parts[2]);
                        itemsSoFar++;
                    }
                } catch (ClassNotFoundException e) {
                    switch (parts[0]) {
                        case "-sort":
                            case1 = true;
                            break;
                        case "-calories":
                            case2 = true;
                            break;
                        default:
                            System.out.println("Класс " + parts[0] + " не найден. " + e);
                            break;
                    }
                } catch (NoSuchMethodException ex) {
                    System.out.println(arg + " не может быть включен в завтрак" + " " + ex);
                }

                System.out.println("Завтрак: "); //выводим завтрак таким,каким он был первоначально
                for (Food item : breakfast) {
                    if (item != null) {
                        item.consume();
                        System.out.println(" " + item.calculateCalories());
                    } else {
                        break;
                    }
                }

                if (case1) { //случай "ClassNotFoundException", когда мы задаем параметр -sort
                    Arrays.sort(breakfast, new Comparator() {
                        public int compare(Object f1, Object f2) {
                            if (f1 == null) return 1;
                            if (f2 == null) return -1;

                            if (((Food) f1).calculateCalories() > ((Food) f2).calculateCalories())
                                return -1;
                            else if (((Food) f1).calculateCalories() < ((Food) f2).calculateCalories()) return 1;
                            else return 0;
                        }
                    });

                    System.out.println("Завтрак:"); //ну тут понятно
                    for (Food item : breakfast) {
                        if (item != null) {
                            item.consume();
                            System.out.println(" " + item.calculateCalories());
                        } else {
                            break;
                        }
                    }
                }
            }
        }
}