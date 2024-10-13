package Lab_2_HW;


public class Main {
    public static void main(String[] args) {
        Testable[] tests = {new TestEx1(),new TestEx2()};
        for(Testable test : tests){
            test.testAll();
        }
    }
}