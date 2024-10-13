package Lab_2_HW;

public interface FormOperations {
    int scaleFactor=2;

    void move(int x,int y);
    void shrink();
    void enlarge();
    void changeInnerColor(String color);
    void changeFormColor(String color);
}
