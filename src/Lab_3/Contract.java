package Lab_3;

import java.io.*;
import java.util.ArrayList;

public class Contract implements Storable {
    private final ArrayList<Course> courses;
    Contract(){
        this.courses = new ArrayList<>();
    }
    public void addCourse(Course course){
        this.courses.add(course);
    }
    public void deleteCourse(Type courseType, Stream stream, String name){
        this.courses.removeIf(course ->
                course.compareTo(new Course(name,courseType,stream,0))==0);
    }
    public void sort() throws Exception{
        for(int i =0 ;i<courses.size();i++){
            for(int j=i+1;j<courses.size();j++){
                if(courses.get(i).compareTo(courses.get(j))==0){
                    throw new Exception("Duplicate contracts found!");
                }
            }
        }
        courses.sort(Course::compareTo);
    }

    public void display(){
        for(Course course: courses){
          System.out.println(course);
        }
    }

    @Override
    public void store(String file) throws IOException {
        try(
                FileOutputStream outputFile = new FileOutputStream(file);
                OutputStreamWriter outputStream = new OutputStreamWriter(outputFile);
                PrintWriter pw = new PrintWriter(outputStream);)
        {
            for(Course course : courses){
                pw.println(course);
            }
        }
    }
}
