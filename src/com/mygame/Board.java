import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    private ArrayList<Property> properties;
    private int numSquares;
    private int size;
    private int[] property_types;

    Scanner input = new Scanner(System.in);

    public Board() {
        numSquares = 40;
        size = 8;
        properties = new ArrayList<Property>();
        property_types = new int[numSquares];
    }

    public Property getProperty(int index) {
        return properties.get(index);
    }

    public void buyProperty(int index, Player player) {
        Property property = properties.get(index);
        if (player.getMoney() >= property.getPrice()) {
            player.setMoney(player.getMoney() - property.getPrice());
            property.setOwner(player);
        } else {
            System.out.println("Player does not have enough money to purchase this property.");
        }
    }

    public void movePlayer(Player player, int squares) {
        int currentPosition = player.getPosition();
        int newPosition = (currentPosition + squares) % numSquares;
        player.setPosition(newPosition);
        landedOn(player);
    }

    public void landedOn(Player player) {
        int position = player.getPosition();
        Property property = properties.get(position);
        if (property.getOwner() == null) {
            System.out.println("You landed on " + property.getName() + ". Would you like to purchase it for $" + property.getPrice() + "? (y/n)");
            char inp = ' ';
            inp = input.nextLine().charAt(0);
            if(inp == 'Y' || inp == 'y')
                buyProperty(position, player);
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
                //endGame();
            }
        }
    }


    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int index = i * size + j;
                System.out.print(properties.get(index).getName() + " ");
            }
            System.out.println();
        }
    }

    public void initializeProperties()
    {
        for (int i = 0; i < numSquares; i++) {
            Property property = new Property("Property " + i, i, property_types[i]);
            properties.add(property);
        }
    }
    
    // public void initializeProperties() {
    //     properties = new ArrayList<Property>();
    //     // Connect to the database
    //     Connection conn = null;
    //     try {
    //         // Step 1: Create a connection
    //         conn = DriverManager.getConnection("jdbc:your_db_type://your_db_host:your_db_port/your_db_name", "your_username", "your_password");
    //         // Step 2: Create a statement
    //         Statement stmt = conn.createStatement();
    //         // Step 3: Execute the query
    //         ResultSet rs = stmt.executeQuery("SELECT * FROM properties");
    //         // Step 4: Process the results
    //         while (rs.next()) {
    //             int id = rs.getInt("id");
    //             String name = rs.getString("name");
    //             int price = rs.getInt("price");
    //             int rent = rs.getInt("rent");
    //             Property property = new Property(id, name, price, rent);
    //             properties.add(property);
    //         }
    //         // Step 5: Close the connection
    //         conn.close();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }
}
