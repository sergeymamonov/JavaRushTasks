package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Human grandfather1 = new Human("Леонид", true, 80);
        Human grandfather2 = new Human("Михаил", true, 80);
        Human grandmother1 = new Human("Сипа", false, 80);
        Human grandmother2 = new Human("Валя", false, 80);
        Human father = new Human("Виктор", true, 75);
        Human mother = new Human("Людмила", false, 65);
        Human son = new Human("Сергей", true, 34);
        Human dougte1 = new Human("Катя", false, 41);
        Human dougte2 = new Human("Аня", false, 1);
        ArrayList<Human> grandfather1child = new ArrayList<>();
        ArrayList<Human> grandfather2child = new ArrayList<>();
        ArrayList<Human> grandmother1child = new ArrayList<>();
        ArrayList<Human> grandmother2child = new ArrayList<>();
        ArrayList<Human> fatherchild = new ArrayList<>();
        ArrayList<Human> motherchild = new ArrayList<>();
        ArrayList<Human> sonchild = new ArrayList<>();
        ArrayList<Human> dougter1child = new ArrayList<>();
        ArrayList<Human> dougter2child = new ArrayList<>();
        grandfather1child.add(father);
        grandfather2child.add(mother);
        grandmother1child.add(father);
        grandmother2child.add(mother);
        fatherchild.add(son);
        fatherchild.add(dougte1);
        fatherchild.add(dougte2);
        motherchild.add(son);
        motherchild.add(dougte1);
        motherchild.add(dougte2);
        grandfather1.children = grandfather1child;
        grandfather2.children = grandfather2child;
        grandmother1.children = grandmother1child;
        grandmother2.children = grandmother2child;
        father.children = fatherchild;
        mother.children = motherchild;
        son.children = sonchild;
        dougte1.children = dougter1child;
        dougte2.children = dougter2child;

        System.out.println(grandfather1.toString());
        System.out.println(grandfather2.toString());
        System.out.println(grandmother1.toString());
        System.out.println(grandmother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(son.toString());
        System.out.println(dougte1.toString());
        System.out.println(dougte2.toString());
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
//            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
