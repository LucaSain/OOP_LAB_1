package Lab_9;

public record Pizza(int noIngredients) {
    public static int id=0;
    public int id(){
        id++;
        return id;
    }
}
