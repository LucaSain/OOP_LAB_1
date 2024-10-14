package Lab_3;

public class Card implements Comparable<Card>{
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    private final Rank rank;
    private final Suit suit;

    @Override
    public int compareTo(Card o) {
        int suitComparison = this.suit.compareTo(o.suit);
        if (suitComparison != 0) {
            return suitComparison;
        } else {
            return this.rank.compareTo(o.rank);
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }
}
