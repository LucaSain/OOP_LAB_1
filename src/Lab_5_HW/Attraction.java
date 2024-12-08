package Lab_5_HW;

import java.util.Objects;

public record Attraction(String Location, String Name) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attraction that = (Attraction) o;
        return Objects.equals(Name, that.Name) && Objects.equals(Location, that.Location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Location, Name);
    }
}
