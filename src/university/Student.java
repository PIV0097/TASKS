package university;

import java.util.List;
import java.util.Optional;

public class Student {
    private String name;
    private int age;
    private double averageGrade;
    private List<String> courses;

    public Student(String name, int age, double averageGrade, List<String> courses) {
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
        this.courses = courses;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
