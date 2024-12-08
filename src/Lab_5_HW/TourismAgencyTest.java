package Lab_5_HW;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TourismAgencyTest {

    TourismAgency tp;


    @BeforeEach
    void setUp() {
        tp = new TourismAgency();

        Attraction a1 = new Attraction("Paltinis","AMAZING");
        Attraction a2 = new Attraction("Paltinis","Beautiful");
        Attraction a3 = new Attraction("Ipotesti","AMAZING");
        ArrayList<TouristicPackage> tpk1 = new ArrayList<TouristicPackage>(List.of(new TouristicPackage[]{
                new TouristicPackage("Ten", 123, 33.5),
                new TouristicPackage("One", 123, 33.5),
                new TouristicPackage("Two", 123, 33.5),
                new TouristicPackage("Three", 123, 33.5),
                new TouristicPackage("Four", 123, 33.5),
                new TouristicPackage("Five", 123, 33.5),
                new TouristicPackage("Six", 123, 33.5),
                new TouristicPackage("Seven", 123, 33.5),
                new TouristicPackage("Eight", 123, 33.5),
                new TouristicPackage("Nine", 123, 33.5),
        }));

        for(TouristicPackage t:tpk1){
            t.addAttraction(a1);
            t.addAttraction(a2);
            t.addAttraction(a3);
            tp.addTouristicPackage(t);
        }

    }

    @Test
    void attractionFreq() {
        assertEquals(3,tp.attractionFreq().size());
        assertEquals(10,tp.attractionFreq().get(new Attraction("Paltinis","AMAZING")));
    }

    @Test
    void relativeAttractionFreq() {
        assertEquals(3,tp.relativeAttractionFreq().size());
        assertEquals((double)1/3,tp.relativeAttractionFreq().get(new Attraction("Paltinis","AMAZING")));
    }
}