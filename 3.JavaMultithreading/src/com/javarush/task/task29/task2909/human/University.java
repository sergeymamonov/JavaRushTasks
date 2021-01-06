package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    private final Student student;

    public University(String name, int age) {
        student = new Student(name, age, 0);
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        double delta = 0.01;
        for (Student student : students) {
            if (Math.abs(student.getAverageGrade() - averageGrade) < delta) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maximum = 0d;
        Student studentWithMaxAverageGrade = null;
        for (Student student : students) {
            if (student.getAverageGrade() > maximum) {
                maximum = student.getAverageGrade();
                studentWithMaxAverageGrade = student;
            }
        }
        return studentWithMaxAverageGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        double minimum = Double.MAX_VALUE;
        Student studentWithMinAverageGrade = null;
        for (Student student : students) {
            if (student.getAverageGrade() < minimum) {
                minimum = student.getAverageGrade();
                studentWithMinAverageGrade = student;
            }
        }
        return studentWithMinAverageGrade;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}