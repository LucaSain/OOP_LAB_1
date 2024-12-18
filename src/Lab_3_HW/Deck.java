package Lab_3_HW;

import java.util.*;

public class Deck extends ArrayList<PlayingCard>{
    public final int MAX_SIZE=52;

    void shuffle(){
        Collections.shuffle(this);
    }

    void sort(){
        sort(PlayingCard::compareTo);
    }

    public void generate(){
        Collection<Rank> ranks = List.of(Rank.class.getEnumConstants());
        Collection<Suit> suits = List.of(Suit.class.getEnumConstants());
        for(Rank r: ranks){
            if(r.equals(Rank.JOKER))
                continue;
            for(Suit s: suits){
                this.add(new PlayingCard(r,s));
            }
        }
        this.add(new PlayingCard(Rank.JOKER,Suit.HEARTS));
        this.add(new PlayingCard(Rank.JOKER,Suit.SPADES));
    }

    @Override
    public boolean add(PlayingCard playingCard) {
        if(this.size()>=MAX_SIZE){
            return false;
        }
        return super.add(playingCard);
    }

    @Override
    public void add(int index, PlayingCard element) {
        if(this.size()>=MAX_SIZE){
            return;
        }
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends PlayingCard> c) {
        if(this.size()>=MAX_SIZE){
            return false;
        }
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends PlayingCard> c) {
        if(this.size()>=MAX_SIZE){
            return false;
        }
        return super.addAll(index, c);
    }

    @Override
    public void addFirst(PlayingCard element) {
        if(this.size()>=MAX_SIZE){
            return;
        }
        super.addFirst(element);
    }

    @Override
    public void addLast(PlayingCard element) {
        if(this.size()>=MAX_SIZE){
            return;
        }
        super.addLast(element);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Deck that = (Deck) o;
        return MAX_SIZE == that.MAX_SIZE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), MAX_SIZE);
    }
}


