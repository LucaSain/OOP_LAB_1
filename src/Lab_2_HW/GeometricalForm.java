package Lab_2_HW;

public class GeometricalForm implements FormOperations{
    private int xCoord;
    private int yCoord;
    private String iColor;
    private String fColor;

    public GeometricalForm(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        iColor="None";
        fColor="None";
    }

    @Override
    public void move(int x, int y) {
        xCoord=x;
        yCoord=y;
    }

    @Override
    public void shrink() {
        //do nothing
    }

    @Override
    public void enlarge() {
        //do nothing
    }

    @Override
    public void changeFormColor(String color) {
        fColor = color;
    }

    @Override
    public void changeInnerColor(String color) {
        iColor=color;
    }

    public int getXCoordinate() {
        return xCoord;
    }

    public int getYCoordinate() {
        return yCoord;
    }

    public String getInnerColor() {
        return iColor;
    }

    public String getFormColor() {
        return fColor;
    }
}
