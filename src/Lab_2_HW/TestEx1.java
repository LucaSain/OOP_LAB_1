package Lab_2_HW;

public class TestEx1 implements Testable {
    @Override
    public void testAll(){
        testGeometricalForm();
        testEclipse();
        testRectangle();
        testArrayOfGeometricalForms();
        System.out.println("All test passed.");
    }

    public static void testGeometricalForm(){
        GeometricalForm gForm = new GeometricalForm(10,30);

        //test constructor
        assert gForm.getFormColor().equals("None"):"Form color should have been None";
        assert gForm.getInnerColor().equals("None"):"Form color should have been None";
        assert gForm.getXCoordinate() == 10:"Form x coordinate should have been 10";
        assert gForm.getYCoordinate() == 30:"Form y coordinate should have been 30";
        System.out.println("GeometricalForm constructor test passed.");

        gForm.changeFormColor("Red");
        gForm.changeInnerColor("Red");
        gForm.move(0,20);

        //test proprieties
        assert gForm.getFormColor().equals("Red"):"Form color should have been Red";
        assert gForm.getInnerColor().equals("Red"):"Form color should have been Red";
        assert gForm.getXCoordinate() == 0:"Form x coordinate should have been 0";
        assert gForm.getYCoordinate() == 20:"Form y coordinate should have been 20";
        System.out.println("GeometricalForm methods test passed.");

        System.out.println("GeometricalForm test passed.");
    }

    public static void testRectangle(){
        Rectangle rectangle = new Rectangle(10,10,20,30);

        //test constructor
        assert rectangle.getWidth() == 20:"Rectangle width should have been 20";
        assert rectangle.getHeight() == 30 :"Rectangle height should have been 30";
        System.out.println("Rectangle constructor test passed.");

        rectangle.enlarge();
        assert rectangle.getWidth() == 40 :"Rectangle height should have been 40";
        assert rectangle.getHeight() == 60 :"Rectangle height should have been 60";

        rectangle.shrink();
        assert rectangle.getWidth() == 20:"Rectangle width should have been 20";
        assert rectangle.getHeight() == 30 :"Rectangle height should have been 30";
        System.out.println("Rectangle methods test passed.");

        System.out.println("Rectangle tests passed.");

    }

    public static void testEclipse(){
        Eclipse eclipse = new Eclipse(10,10,20,30);

        //test constructor
        assert eclipse.getHorizRadius() == 20:"Eclipse horizontal radius should have been 20";
        assert eclipse.getVertRadius() == 30 :"Eclipse vertical radius should have been 30";
        System.out.println("Eclipse constructor test passed.");

        eclipse.enlarge();
        assert eclipse.getHorizRadius() == 40 :"Eclipse horizontal radius should have been 40";
        assert eclipse.getVertRadius() == 60 :"Eclipse vertical radius should have been 60";

        eclipse.shrink();
        assert eclipse.getHorizRadius() == 20:"Eclipse horizontal radius should have been 20";
        assert eclipse.getVertRadius() == 30 :"Eclipse vertical radius should have been 30";
        System.out.println("Eclipse methods test passed.");

        System.out.println("Eclipse tests passed.");
    }

    public static void testArrayOfGeometricalForms(){
        GeometricalForm[] geometricalForms={
                new Eclipse(10,10,20,30),
                new Rectangle(10,10,20,30),
                new GeometricalForm(10,10)
        };

        for(var geoForm : geometricalForms){
            geoForm.move(20,20);
            geoForm.changeInnerColor("Red");
            assert geoForm.getXCoordinate()==20:"Form x coordinate should have been 20";
        }

        System.out.println("Geometrical Form array test passed.");
    }
}
