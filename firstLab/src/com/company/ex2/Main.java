package com.company.ex2;

public class Main {

    public static void main(String[] args) {
	    Student student_1 = new Student();
        Student student_2 = new Student();
        Student student_3 = new Student();
        Student student_4 = new Student();

        University asem = new University();
        University utm = new University();

        student_1.age = 20;
        student_2.age = 19;
        student_3.age = 18;
        student_4.age = 21;

        student_1.mark = 3;
        student_2.mark = 2.5f;
        student_3.mark = 2.7f;
        student_4.mark = 8.2f;

        Student[] studentsAsem = {student_1, student_2};
        Student[] studentsUtm = {student_3, student_4};

        asem.students = studentsAsem;
        asem.name = "ASEM";
        asem.foundationYear = 1991;

        utm.students = studentsUtm;
        utm.name = "Technical University of Moldova";
        utm.foundationYear = 1981;

        float commonAverage = (utm.findAverage() + asem.findAverage()) / 2;

        System.out.println(commonAverage);
    }

}

class University {
    String name;
    int foundationYear;
    Student[] students;


    float findAverage() {
        float average = 0;
        float sum = 0;

        for (int i = 0; i < students.length; i++) {
            sum += students[i].mark;
        }

        average = sum / students.length;

        return average;
    }
}

class Student {
    String name;
    int age;
    float mark;
}