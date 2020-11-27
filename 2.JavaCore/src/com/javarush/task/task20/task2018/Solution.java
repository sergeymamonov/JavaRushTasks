package com.javarush.task.task20.task2018;

import java.io.*;

/*
Найти ошибки
*/
public class Solution implements Serializable {
    public static class A {

        protected String nameA = "A";

        public A() {}

        public A(String nameA) {
            this.nameA += nameA;
        }

//        public void save(PrintWriter writer) throws Exception {
//            writer.println(nameA);
//        }
//
//        public void load(BufferedReader reader) throws Exception {
//            nameA = reader.readLine();
//        }
    }

    public class B extends A implements Serializable {

        private String nameB;

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) {
            try {
                objectOutputStream.defaultWriteObject();
                objectOutputStream.writeObject(nameA);
//                PrintWriter writer = new PrintWriter(objectOutputStream);
//                writer.println(nameA);
            }
            catch (Exception e) {

            }
        }

        private void readObject(ObjectInputStream objectInputStream) {
            try {
                objectInputStream.defaultReadObject();
                nameA = (String) objectInputStream.readObject();
            }
            catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B) ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}
