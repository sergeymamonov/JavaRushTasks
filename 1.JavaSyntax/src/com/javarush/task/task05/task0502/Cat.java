package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
//        int count = 0;

        int ageScore = Integer.compare(this.age, anotherCat.age);
        int strengthScore = Integer.compare(this.strength, anotherCat.strength);
        int weightSore = Integer.compare(this.weight, anotherCat.weight);

        int score = ageScore + strengthScore + weightSore;
        return score > 0;


//        if (this.age > anotherCat.age) {
//            count++;
//        }
//        if (this.strength > anotherCat.strength) {
//            count++;
//        }
//        if (this.weight > anotherCat.weight) {
//            count++;
//        }
//        if (count > 2) {
//            return true;
//        }
//        else {
//            return false;
//        }
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.age = 5;
        cat1.weight = 11;
        cat1.strength=10;

        Cat cat2 = new Cat();
        cat2.age = 5;
        cat2.weight = 11;
        cat2.strength=10;

        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat1));

    }
}
