package Lab_3;


import java.io.IOException;

public class Main {
    public static void main(String[] args) {
       Contract ct = new Contract();
       Course course3 = new Course("Masina",Type.DISCIPLINE,Stream.ENGLISH,39);
       Course course1 = new Course("Masina",Type.SPECIALIZATION,Stream.ENGLISH,39);
       Course course2 = new Course("Masina",Type.FUNDAMENTAL,Stream.ENGLISH,39);
       ct.addCourse(course1);
       ct.addCourse(course2);
       ct.addCourse(course3);

       try {
           ct.sort();
           ct.store("main.txt");
       }
       catch (Exception e){
           System.out.println(e.toString());
       }

       Hand hand = new Hand();
       Card c1 = new Card(Rank.ACE,Suit.DIAMONDS);
       Card c2 = new Card(Rank.KING,Suit.DIAMONDS);
       Card c3 = new Card(Rank.SEVEN,Suit.DIAMONDS);
       try{
       hand.addCard(c1);
       hand.addCard(c2);
       hand.addCard(c3);

       hand.sort();
       hand.store("something.txt");
       }
       catch (Exception e){
           System.out.println(e.toString());
       }
    }
}