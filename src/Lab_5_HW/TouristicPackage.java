package Lab_5_HW;

import java.util.ArrayList;
import java.util.Objects;

public class TouristicPackage {
    private final String name;
    private final int id;
    private final double price;
    private final ArrayList<Attraction> attractions;

    public void addAttraction(Attraction a){
        if(attractions.contains(a)){
            throw new IndexOutOfBoundsException("Duplicate Attraction");
        }
        attractions.add(a);
    }

    public TouristicPackage(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.attractions = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TouristicPackage that = (TouristicPackage) o;
        return id == that.id && Double.compare(price, that.price) == 0 && Objects.equals(name, that.name) && Objects.equals(attractions, that.attractions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, price, attractions);
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    @Override
    public String toString() {
        return "TouristicPackage{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", attractions=" + attractions +
                '}';
    }
}
