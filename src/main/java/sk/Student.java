package sk;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Student {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Mike", 80));
        students.add(new Student("James", 57));
        students.add(new Student("Alan", 21));

        studentsThatPass(students.stream(), 50)/*.forEach(System.out::println)*/;
    }
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
    public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {


        return null;
    }
}



