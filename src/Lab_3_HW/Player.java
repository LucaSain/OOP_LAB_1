package Lab_3_HW;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Player implements Comparable<Player>{
    private final String name;
    private ArrayList<PlayingCard> hand;
    private final ArrayList<PlayingCard> discard;
    private final Game game;


    public ArrayList<PlayingCard> getHand() {
        return hand;
    }

    public Collection<PlayingCard> removeMany(int cnt){
        if(hand.size()<cnt){
            hand.addAll(discard);
            if(hand.size()<cnt){
                game.removePlayer(this);
                if(!hand.isEmpty())
                    return hand;
                else
                    return null;
            }
            Collections.shuffle(hand);
            discard.clear();
        }

        Collection<PlayingCard> _l = hand.subList(hand.size()-cnt, hand.size());
        hand = new ArrayList<>(hand.subList(0,hand.size()-cnt));
        return _l;
    }

    public Player(String name, Game game) {
        this.name = name;
        this.hand = new ArrayList<PlayingCard>();
        this.discard = new ArrayList<PlayingCard>();
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public PlayingCard last(){
        if(hand.isEmpty() ){
            hand.addAll(discard);
            if(discard.isEmpty()) {
                game.removePlayer(this);

               if(!hand.isEmpty()){
                   return hand.removeLast();
               }
               else
                   return null;

            }

            Collections.shuffle(hand);
            discard.clear();
        }
        return hand.removeLast();
    }

    public void win(Collection<PlayingCard> pile){
        discard.addAll(pile);
    }

    public void dealCard(PlayingCard playingCard){
        hand.add(playingCard);
    }


    public void display(){
        System.out.println(getName());
        System.out.print(hand.size()+" ");
        for(PlayingCard playingCard:hand){
            System.out.print(playingCard.toString()+ " ");
        }
        System.out.println();
    }

    public void clear(){
        this.hand.clear();
        this.discard.clear();
    }

    public boolean flushDiscard() {
        if (hand.isEmpty()) {
            hand.addAll(discard);
            discard.clear();
            if (hand.isEmpty()) {
                return true;
            }
            Collections.shuffle(hand);
        }
        return false;
    }

    @Override
    public int compareTo(@NotNull Player o) {
         return hand.getLast().compareTo(o.hand.getLast());
    }
}
