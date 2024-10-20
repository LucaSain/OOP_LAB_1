package Lab_3_HW;

public class Main {
    public static void main(String[] args) {
        Analytics analytics = new Analytics();
        Game game = new Game(analytics);
        Player[] players = {
                new Player("Jon", game),
                new Player("Ive", game),
                new Player("Ivse", game),
                new Player("Ivde", game)
        };




        for(int i=0;i<10;i++) {
            game.clear();
            for (Player p : players) {
                p.clear();
                game.addPlayer(p);
            }
            game.dealCards();
            game.playGame();
        }
        System.out.println(analytics);
    }
}