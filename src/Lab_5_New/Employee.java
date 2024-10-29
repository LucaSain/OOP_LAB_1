package Lab_5_New;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Objects;

public class Employee implements Comparable<Employee>{

    private final String name;
    private final String CNP;
    private final Date hiringDate;
    private final String specialization;
    private final double salary;

    public Employee(String name, String CNP, Date hiringDate, String specialization, double salary) {
        this.name = name;
        this.CNP = CNP;
        this.hiringDate = hiringDate;
        this.specialization = specialization;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getCNP() {
        return CNP;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", CNP='" + CNP + '\'' +
                ", hiringDate=" + hiringDate +
                ", specialization='" + specialization + '\'' +
                ", salary=" + salary +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(getSalary(), employee.getSalary()) == 0 && Objects.equals(getName(), employee.getName()) && Objects.equals(getCNP(), employee.getCNP()) && Objects.equals(getHiringDate(), employee.getHiringDate()) && Objects.equals(getSpecialization(), employee.getSpecialization());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCNP(), getHiringDate(), getSpecialization(), getSalary());
    }

    @Override
    public int compareTo(@NotNull Employee o) {
        return this.CNP.compareTo(o.getCNP());
    }
}
