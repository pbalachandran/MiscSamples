package com.sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StraightLambda {


    public static class Student {
        private String name;
        private String ssn;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSsn() {
            return ssn;
        }

        public void setSsn(String ssn) {
            this.ssn = ssn;
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("pradeep"));
        students.add(new Student("geetha"));
        students.add(new Student("pattu"));

//        List<String> names = students.stream()
//                .map(student -> "Hello " + student.getName())
//                .map(greeting -> String::toUpperCase)
//                .collect(Collectors.toList());
//        names.forEach(System.out::println);
    }
}
