package Lab_3;

public enum Stream {
    ENGLISH("English"), FRENCH("French"), GERMAN("German");
    private final String value;
    Stream(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
