package Lab_2_HW;

public class Eclipse extends GeometricalForm{
    private int hRadius;
    private int vRadius;

    public Eclipse(int x, int y, int hRadius, int vRadius) {
        super(x, y);
        this.hRadius = hRadius;
        this.vRadius = vRadius;
    }

    public int getHorizRadius() {
        return hRadius;
    }

    public int getVertRadius() {
        return vRadius;
    }

    @Override
    public void shrink() {
        hRadius/=scaleFactor;
        vRadius/=scaleFactor;
    }

    @Override
    public void enlarge() {
        hRadius*=scaleFactor;
        vRadius*=scaleFactor;
    }
}
