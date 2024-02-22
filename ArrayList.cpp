import java.util.List;
import java.util.Arrays;
import java.util.stream.*;
import java.util.*;
import java.util.stream.Collectors;
class ArrayList
{
    int id;
    String name;
    float cgpa;
    student(int id, String name, float cgpa)
    {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
} class k21bp
{
public
    static void main(String args[])
    {
        ArrayList<student> al = new ArrayList<>();
        al.add(new student(1, "Shruti", 8.93f));
        al.add(new student(2, "tushar", 9.93f));
        al.add(new student(3, "mohan", 6.93f));
        al.add(new student(4, "manik", 4.93f));
        al.add(new student(5, "Sham", 7.93f));
        al.add(new student(6, "ram", 8.93f));
        al.add(new student(7, "suraj", 8.93f));
        al.add(new student(8, "neha", 8.93f));
        Stream<student> str = al.stream();
        Set<Float> studentscore = str.filter(score->score.cgpa > 5)
                                      .map(score->score.cgpa)
                                      .collect(Collectors.toSet());
        System.out.println(studentscore);
    }
}