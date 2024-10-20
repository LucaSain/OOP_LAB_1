package Lab_3_HW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class Analytics {
   private final ArrayList<Integer> turns;
   Analytics(){
       this.turns = new ArrayList<>();
   }
   public void addEntry(int turn){
       turns.add(turn);
   }

   private int total(){
      return turns.stream().reduce(0, Integer::sum);
   }

   private int min(){
       return Collections.min(turns);
   }

   private int max(){
       return Collections.max(turns);
   }

   private int mean(){
       if(!turns.isEmpty())
        return total()/turns.size();
       return -1;
   }

    @Override
    public String toString() {
        return "total"+ total()+ " min"+min()+" max"+ max()+ " mean"+ max();
    }
}
