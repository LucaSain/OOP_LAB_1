package Lab_3_HW;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Game {
    private final ArrayList<Player> players;
    private final Deck deck;
    private final Analytics analyticsEngine;
    Game(Analytics analyticsEngine){
        deck = new Deck();
        deck.generate();
        players = new ArrayList<Player>();
        this.analyticsEngine = analyticsEngine;
    }

    public void addPlayer(Player p){
        players.add(p);
    }

    public void dealCards(){
        deck.generate();
        deck.shuffle();

        Iterator<Player> it = players.iterator();
        while (it.hasNext()){
            if(deck.isEmpty()){
                break;
            }
            it.next().dealCard(deck.removeLast());
            if(!it.hasNext()){
                it = players.iterator();
            }
        }
    }

    public void clear(){
        this.players.clear();
        this.deck.clear();
    }




    public void playGame(){
        int turn=0;
        while (players.size()>1){
            turn+=1;
            ArrayList<Player> currentPlayers = new ArrayList<>(players);
            ArrayList<PlayingCard> pile = new ArrayList<>();
            playTurn(currentPlayers,pile);
            players.removeIf(Player::flushDiscard);
        }
        if(players.isEmpty()){
            System.out.println("A draft");
        }
        else{
            System.out.println("This player won");
            System.out.println(players.getLast().getName());
        }
        analyticsEngine.addEntry(turn);
    }

    private void playTurn(ArrayList<Player> currentPlayers, ArrayList<PlayingCard> pile) {
        currentPlayers.sort(Player::compareTo);

        Player top = currentPlayers.getLast();

        Iterator<Player> it = currentPlayers.subList(0, currentPlayers.size() - 1).iterator();
        while (it.hasNext()) {
            Player p = it.next();

            if(p.compareTo(top)<0){
                PlayingCard tmp = p.last();
                if (tmp == null) {
                    it.remove();
                    continue;
                }
                pile.add(tmp);
                it.remove();
            }
            else {
                PlayingCard tmp = p.last();
                if (tmp == null) {
                    it.remove();
                    continue;
                }
                pile.add(tmp);
            }

        }

        if (top.last() != null) {
            pile.add(top.last());
        }

        playWarTurn(currentPlayers, pile);
    }

    private void playWarTurn(ArrayList<Player> currentPlayers, ArrayList<PlayingCard> pile) {


        if (currentPlayers.size() == 1) {
            currentPlayers.getLast().win(pile);
            return;
        }

        // If no players are left, it's a draft
        if (currentPlayers.isEmpty()) {
            return;
        }

        // Go through each player and add 3 cards or remove them if they don't have enough
        Iterator<Player> it = currentPlayers.iterator();
        while (it.hasNext()) {
            Player p = it.next();
            Collection<PlayingCard> c = p.removeMany(3);

            // If the player doesn't have enough cards, they are removed
            if (c == null || c.isEmpty()) {
                it.remove();
            } else {
                // Otherwise, add their cards to the pile
                pile.addAll(c);
            }
        }

        // If no players left, it's a draft
        if (currentPlayers.isEmpty()) {
            return;
        }

        // If only one player left, they win
        if (currentPlayers.size() == 1) {
            currentPlayers.getLast().win(pile);
            return;
        }

        currentPlayers.removeIf(player -> player.flushDiscard());



        // Sort the players again
        currentPlayers.sort(Player::compareTo);

        // Get the top player
        Player top = currentPlayers.getLast();

        // Iterate through the rest of the players and add cards to the pile
        it = currentPlayers.subList(0, currentPlayers.size() - 1).iterator();
        while (it.hasNext()) {
            Player p = it.next();

            if(p.compareTo(top)<0){
                PlayingCard tmp = p.last();
                if (tmp == null) {
                    it.remove();
                    continue;
                }
                pile.add(tmp);
                it.remove();
            }
            else {
                PlayingCard tmp = p.last();
                if (tmp == null) {
                    it.remove();
                    continue;
                }
                pile.add(tmp);
            }

        }

        // Add the top player's card to the pile
        if (top.last() != null) {
            pile.add(top.last());
        }

        // Recur for the next war turn
        playWarTurn(currentPlayers, pile);
    }


    public void removePlayer(Player player){
        players.remove(player);
    }
}
