import java.util.Random;
import java.util.Scanner;

public class GameEngine {
    private Random rand;
    Scanner input = new Scanner(System.in);

    public GameEngine() {
        rand = new Random();
    }

    public int rollDice() {
        int roll1 = rand.nextInt(6) + 1;
        int roll2 = rand.nextInt(6) + 1;
        int total = roll1 + roll2;
        System.out.println("You rolled a " + roll1 + " and a " + roll2 + ", for a total of " + total);
        return total;
    }

    public void movePlayer(Player player, int spaces) {
        int currentPosition = player.getPosition();
        if (currentPosition + spaces > 40 )
        {
            if(player.is_jail())
                player.setMoney(player.getMoney() + 100);
            player.set_jail(false);
        }
        int newPosition = (currentPosition + spaces) % 40;
        player.setPosition(newPosition);
    }

    public void endGame() {
        System.out.println("The game is over. Thank you for playing!");
        input.close();
    }
    public void handleLanding(Player player, Board board) {
        int position = player.getPosition();
        Property property = board.getProperty(position);
        if (property.getOwner() == null) {
            System.out.println("You landed on " + property.getName() + ". Would you like to purchase it for $" + property.getPrice() + "? (y/n)");
            char inp = ' ';
            inp = input.nextLine().charAt(0);
            if(inp == 'Y' || inp == 'y')
                board.buyProperty(position, player);
            else
            {
                return;
            }
        } 
        else {
            System.out.println("You landed on " + property.getName() + ", which is owned by " + property.getOwner().getName());
            Player owner = property.getOwner();
            int rent = property.getRent();
            if(player.getMoney() >= rent)
            {
                player.setMoney(player.getMoney() - rent);
                owner.setMoney(owner.getMoney() + rent);
                System.out.println("You paid $" + rent + " in rent to " + owner.getName());
            }
            else
            {
                System.out.println("You don't have enough money to pay rent. You lost the game.");
                endGame();
            }
        }
    }
}
