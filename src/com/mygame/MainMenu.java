import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainMenu extends JFrame {

    private JButton startButton;
    private JButton optionsButton;
    private JButton quitButton;

    public MainMenu() {
        // Set up the main menu window
        setTitle("Monopoly - Main Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create the start button
        startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        add(startButton);

        // Create the options button
        optionsButton = new JButton("Options");
        optionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showOptions();
            }
        });
        add(optionsButton);

        // Create the quit button
        quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quit();
            }
        });
        add(quitButton);

        // Show the main menu window
        setVisible(true);
    }

    private void startGame() {
        // Start the game
        System.out.println("asdsadasd");
        Game game = new Game();
        game.startGame();
        
        while (!game.isOver()) {
            game.takeTurn();
            game.nextPlayer();
        }
        game.endGame();
        (game.getPlayers()).forEach(player -> System.out.println(player.getName() + " your money is :" + player.getMoney()));
    }

    public static void showOptions() {
        JFrame optionsFrame = new JFrame("Options");
        optionsFrame.setSize(300, 200);
        optionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(3, 2));

        JLabel fullscreenLabel = new JLabel("Fullscreen:");
        JCheckBox fullscreenCheckbox = new JCheckBox();
        optionsPanel.add(fullscreenLabel);
        optionsPanel.add(fullscreenCheckbox);

        JLabel muteLabel = new JLabel("Mute:");
        JCheckBox muteCheckbox = new JCheckBox();
        optionsPanel.add(muteLabel);
        optionsPanel.add(muteCheckbox);

        JButton saveButton = new JButton("Save");
        optionsPanel.add(saveButton);

        optionsFrame.add(optionsPanel);
        optionsFrame.setVisible(true);
    }

    private void quit() {
        // Exit the program
        System.exit(0);
    }

    // public static void main(String[] args) {
    //     new MainMenu();
    // }
}
