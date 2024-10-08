package Lab_1_HW;

public class Person {
    private String name;
    private String surname;
    private String CNP;

    public String getSurname() {
        return surname;
    }

    public String getCNP() {
        return CNP;
    }

    public String getName() {
        return name;
    }



    public Person(String name, String surname, String CNP) {
        this.name = name;
        this.surname = surname;
        this.CNP = CNP;
    }



}
