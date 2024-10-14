package Lab_3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Hand implements Storable{
    private final ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    public void addCard(Card c) throws Exception{
       if(cards.stream().anyMatch(card -> card.compareTo(c) == 0))
           throw new Exception("Duplicate card!");
        cards.add(c);
    }

    public void deleteCard(Rank rank, Suit suit){
        this.cards.removeIf(course ->
                course.compareTo(new Card(rank,suit))==0);
    }

    public void sort(){
        cards.sort(Card::compareTo);
    }

    public void display(){
        for(Card card : cards){
            System.out.println(card);
        }
    }

    @Override
    public void store(String file) throws IOException {
        try(
                FileOutputStream outputFile = new FileOutputStream(file);
                OutputStreamWriter outputStream = new OutputStreamWriter(outputFile);
                PrintWriter pw = new PrintWriter(outputStream);)
        {
            for(Card course : cards){
                pw.println(course);
            }
        }
    }
}
