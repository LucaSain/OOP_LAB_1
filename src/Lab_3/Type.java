package Lab_3;

public enum Type {
    FUNDAMENTAL("Fundamental"), SPECIALIZATION("Specialization"), DISCIPLINE("Discipline");

    private final String value;
    Type(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
