package Lab_3;

public record Course(String name, Type courseType, Stream stream, int creditPoints) implements Comparable<Course> {
    @Override
    public int compareTo(Course o) {
        if (this.stream().compareTo(o.stream()) == 0) {
            if (this.courseType().compareTo(o.courseType()) == 0) {
                return this.name().compareTo(o.name());
            }
            return this.courseType().compareTo(o.courseType());
        }
        return this.stream().compareTo(o.stream());
    }


    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", courseType=" + courseType +
                ", stream=" + stream +
                ", creditPoints=" + creditPoints
                ;
    }
}
