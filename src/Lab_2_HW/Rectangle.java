package Lab_2_HW;

public class Rectangle extends GeometricalForm{
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void enlarge() {
        width*=scaleFactor;
        height*=scaleFactor;
    }

    @Override
    public void shrink() {
        width/=scaleFactor;
        height/=scaleFactor;
    }
}
