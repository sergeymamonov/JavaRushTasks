package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human grandfather1 = new Human("Leonid", true, 80);
        Human grandfather2 = new Human("Mihail", true, 80);
        Human grandmother1 = new Human("Sypa", false, 80);
        Human grandmother2 = new Human("Valya", false, 82);

        Human father = new Human("Viktor", true, 76, grandfather2, grandmother2);
        Human mother = new Human("Luda", false, 65, grandfather1, grandmother1);

        Human son1 = new Human("Sergey", true, 34, father, mother);
        Human dogter1 = new Human("Katya", false, 41, father, mother);
        Human dogter2 = new Human("Anya", false, 1, father, mother);

        System.out.println(grandfather1.toString());
        System.out.println(grandfather2.toString());
        System.out.println(grandmother1.toString());
        System.out.println(grandmother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(son1.toString());
        System.out.println(dogter1.toString());
        System.out.println(dogter2.toString());
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            name = this.name;
            sex = this.sex;
            age = this.age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            name = this.name;
            sex = this.sex;
            age = this.age;
            father = this.father;
            mother = this.mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}