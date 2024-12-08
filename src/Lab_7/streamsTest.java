package Lab_7;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class streamsTest {
    ArrayList<Course> courses;
    List<Student> students;

    @Before
    public void setUp() throws Exception {
        courses = new ArrayList<>();
        students = new ArrayList<>();
        Student std1 = new Student(1, "asda", "1113EC", new ArrayList<Course>());
        Student std2 = new Student(2, "asdb", "1112EC", new ArrayList<Course>());
        Student std3 = new Student(3, "asdc", "1112EC", new ArrayList<Course>());
        Student std4 = new Student(4, "asdd", "1112EC", new ArrayList<Course>());
        Student std5 = new Student(5, "asde", "1112EC", new ArrayList<Course>());

        Course c1 = new Course(11,23,2,"Physics1",new ArrayList<Student>());
        Course c2 = new Course(12,26,2,"Physics2",new ArrayList<Student>());
        Course c3 = new Course(13,23,2,"Physics3",new ArrayList<Student>());
        Course c4 = new Course(14,30,2,"Physics4",new ArrayList<Student>());
        Course c5 = new Course(15,23,2,"Physics5",new ArrayList<Student>());

        students.addAll(List.of(std1,std2,std3,std4,std5));
        courses.addAll(List.of(c1,c2,c3,c4,c5));


        for(Student s : students){
            s.courses().addAll(courses);
            for(Course c : courses){
                c.students().add(s);
            }
        }

    }

    @Test
    public void exercise1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        list = list.stream().filter((x)->{return x%2==1;}).map((x)->x*x).toList();
        assertEquals(5,list.size());
        assertEquals(Optional.of(25), Optional.ofNullable(list.get(2)));
    }


    @Test
    public void exercise2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum = list.stream().map((x)->x*x).reduce(Integer::sum).get();
        assertEquals((10*11*21/6), sum);
    }

    @Test
    public void exercise3a(){
        List<String> list = Arrays.asList("one","two","three","four","five","six","seven","eight","nine");
        Map<Integer, Integer> map = list.stream()
                .collect(Collectors.groupingBy(
                        String::length, // Group by string length
                        Collectors.summingInt(e -> 1) // Count occurrences
                ));
        assertEquals(Optional.of(3),Optional.of( map.get(3)));
        assertEquals(Optional.of(3),Optional.of( map.get(5)));

    }

    @Test
    public void exercise4(){
        List<String> list = Arrays.asList("one","two","two","two","five","six","two","eight","nine");

        list = list.stream().distinct().toList();

        assertEquals("one",list.get(0));
        assertEquals("two",list.get(1));
    }
    @Test
    public void exercise5(){
        List<Integer> millionIntegers = IntStream.rangeClosed(1, 1_000_000)
                .boxed()
                .toList();

        Optional<Integer> sum = millionIntegers.parallelStream().reduce(Integer::sum);
        System.out.println(sum.get());
    }

    @Test
    public void exercise6(){
        students = students.stream().filter(s -> !s.courses().stream().filter(c -> c.creditPoints() > 5).toList().isEmpty()).toList();
        assertEquals(5,students.size());
    }

    @Test
    public void exercise7(){

        students = students.stream().filter(
                s -> {
                   return s.courses().stream().mapToInt(Course::creditPoints).sum() > 30;
                }
        ).toList();
        assertEquals(5,students.size());
    }

    @Test
    public void exercise8(){
        @NotNull Map<Integer, @NotNull List<Integer>> courseToStudentMap = students.stream()
                .flatMap(student -> student.courses().stream()
                        .map(course -> new AbstractMap.SimpleEntry<>(course.courseID(), student.StudentID())))
                .collect(Collectors.groupingBy(
                        AbstractMap.SimpleEntry::getKey,
                        Collectors.mapping(AbstractMap.SimpleEntry::getValue, Collectors.toList())
                ));

        System.out.println(courseToStudentMap);
    }

    @Test
    public void exercise9(){

        String group = "1112EC";
        students = students.stream()
                .filter(student -> student.group().equals(group)) // Filter by group
                .sorted(Comparator.comparing(Student::name)) // Sort by name
                .limit(5).toList();

        for(Student s : students){
            System.out.println(s.name());
        }
    }

    @Test
    public void exercise10(){
        Map<String, List<Course>> groupToCoursesMap = students.stream()
                .collect(Collectors.groupingBy(
                        Student::group, // Key: Group
                        Collectors.mapping(
                                Student::courses, // Extract courses for each student
                                Collectors.flatMapping(
                                        List::stream, // Flatten the course lists
                                        Collectors.toList() // Collect as a single list
                                )
                        )
                ));

        // Print the result
        groupToCoursesMap.forEach((group, courses) ->{
                System.out.println(group);
                courses.forEach(c -> {
                    System.out.println(c.fullName());
                });
        }
        );
    }

    @Test
    public void exercise11(){

        String group = "1112EC";
        String s = students.stream()
                .filter(student -> student.group().equals(group))
                .map(Student::name)
                .collect(Collectors.joining(", "));

        System.out.println(s);

    }
}