package Lab_5_HW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TourismAgency {
    private final ArrayList<TouristicPackage> touristicPackages;
    private final ArrayList<Attraction> attractions;

    public TourismAgency() {
        touristicPackages = new ArrayList<>();
        attractions = new ArrayList<>();
    }

    public void addAttraction(Attraction a){
        if(attractions.contains(a)){
            throw new IndexOutOfBoundsException("Duplicate attraction");
        }
        attractions.add(a);
    }

    public void addTouristicPackage(TouristicPackage t){
        if(touristicPackages.contains(t)){
            throw new IndexOutOfBoundsException("Duplicate touristic package");
        }
        touristicPackages.add(t);
    }

    public Map<Attraction,Integer> attractionFreq(){
        HashMap<Attraction,Integer> attractionFreqMap = new HashMap<>();
        for(TouristicPackage t : touristicPackages){
            for(Attraction a : t.getAttractions()){
                if(!attractionFreqMap.containsKey(a))
                    attractionFreqMap.put(a, 1);
                else {
                    attractionFreqMap.replace(a, attractionFreqMap.get(a) + 1);
                }
            }
        }
        return attractionFreqMap;
    }

    public Map<Attraction,Double> relativeAttractionFreq(){
        int totalAttrations=0;
        for(TouristicPackage t : touristicPackages){
            totalAttrations += t.getAttractions().size();
        }

        var attractionFreqMap = attractionFreq();
        Map<Attraction,Double> relativeAttractionFreq = new HashMap<>();
        for(Map.Entry<Attraction,Integer> entry : attractionFreqMap.entrySet()){
            relativeAttractionFreq.put(entry.getKey(), (double)entry.getValue() / (double)totalAttrations);
        }
        return relativeAttractionFreq;
    }

}
