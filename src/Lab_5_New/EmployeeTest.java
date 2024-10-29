package Lab_5_New;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    ArrayList<Employee> employees;

    @BeforeEach
    void setUp() {
        employees = new ArrayList<Employee>();
        Calendar calendar =new GregorianCalendar();
        Date date = calendar.getTime();
        for (int i = 0; i < 10; i++) {
            Employee e = new Employee(i%5+"",i%5*10+"",date,"engineer",12.0);
            employees.add(e);
        }

    }
    //@Test
    void display() {
        for(Employee employee : employees){
            System.out.println(employee);
        }
    }
    @Test
    void ParseBackwards(){
        ListIterator<Employee> it = employees.listIterator(employees.size());
        Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        Employee employee = new Employee(2+"",40+"",date,"engineer",12.0);
        while (it.hasPrevious()){
            if(it.previousIndex()== employees.size()/2){
                it.add(employee);
            }
            it.previous();
        }
        assertEquals(employee, employees.get(employees.size()/2));
    }

    @Test
    void HashSetTest(){
       HashSet<Employee> hs = new HashSet<Employee>(employees);
       assertEquals(5,hs.size());
    }

    @Test
    void TreeSetTest(){
        TreeSet<Employee> ts = new TreeSet<Employee>(employees);
        assertEquals(5,ts.size());
    }

    @Test
    void MapTest(){
        Map<String,Employee> map = new HashMap<String,Employee>();
        for(Employee employee : employees){
            map.put(employee.getName(), employee);
        }
        assertEquals("2",map.get("2").getName());
    }
}