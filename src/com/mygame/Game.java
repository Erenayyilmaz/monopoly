import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private int currentPlayer;
    private Board board;
    private GameEngine engine;
    private boolean is_over = false;

    public Game() {
        players = new ArrayList<Player>();
        currentPlayer = 0;
        board = new Board();
        engine = new GameEngine();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void startGame()
    {
        // Code to initialize players
//        for (int i = 0; i < players.size(); i++) {
        for (int i = 0; i < 2; i++) {
                players.add(new Player("Player " + (i + 1), i));
            players.get(i).setMoney(100);
            players.get(i).setPosition(0);
            //players.get(i).setName("Player " + (i + 1));
        }
        // players.add(new Player("Player1"));
        // players.add(new Player("Player2"));
        // Code to initialize game board
        board.initializeProperties();
        
    }

    public void nextPlayer() {
        currentPlayer = (currentPlayer + 1) % players.size();
    }

    public void endGame() {
        is_over = true;
        System.out.println("The game is over. The winner is " + players.get(currentPlayer).getName());
    }

    public void takeTurn() {
        System.out.println("it is your turn:" + players.get(currentPlayer).getName() + "your money is :" + players.get(currentPlayer).getMoney());
        int roll = engine.rollDice();
        engine.movePlayer(players.get(currentPlayer), roll);
        engine.handleLanding(players.get(currentPlayer), board);
    }

    public boolean isOver() {
        return is_over;
    }


}
