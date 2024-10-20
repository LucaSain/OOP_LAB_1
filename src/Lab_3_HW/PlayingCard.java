package Lab_3_HW;

public class PlayingCard implements Comparable<PlayingCard>{

    private final Rank rank;
    private final Suit suit;


    public PlayingCard(Rank rank, Suit suit) {
        this.rank=rank;
        this.suit=suit;
    }

    @Override
    public int compareTo(@org.jetbrains.annotations.NotNull PlayingCard o) {
        return this.rank.compareTo(o.rank);
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }
}
