import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Project_6_v2{

    public static String[][] game = new String[10][10];

    static Human human = new Human();

    static HashMap<Integer, Goblin> goblins = new HashMap<>();

    static Goblin goblin1 = new Goblin(0,0);

    static Goblin goblin2 = new Goblin(2,0);

    static Goblin goblin3 = new Goblin(4,0);

    static Goblin goblin4 = new Goblin(6,0);

    static Goblin goblin5 = new Goblin(8,0);

    static String helpStr = "This game is a turn based game where the Humans are trying to kill the Goblins,\n" +
            "and vice versa. The Humans are represented by the letter H, the Goblins by letter G,\n" +
            "and random treasure by the letter T. Keep an eye out for the treasure! \n" +
            "\nYou control the" + " Human. The Goblins will automatically pursue and attempt to kill the Human when it's their turn, or choose to stay still.\n" +
            "A prompt will display when it's your turn to move, and ask what you want to do. From there,\n" +
            "you can move or access an inventory of items your character has. Movement is in\n" +
            "a north/south/east/west direction. To move, simply type the first letter of the direction\n" +
            "you want to move. Your inventory will contain all your items and weapons on hand.\n" +
            "You can use the Healing Mushroom whenever you wish, but the other items are restricted for\n" +
            "use in combat. \n" + "\nCombat in this game is automatically initiated when the Human and a Goblin\n" +
            "collide. Each one gets a chance to do damage on each other. The Goblins will do their own attack,\n" +
            "but you get to choose what to do in combat. The game will prompt you for what you want to do.\n" +
            "You can either directly attack with one of your weapons, use a Healing Mushroom, Bomb, or Potion.\n" +
            "Directly attacking will use one of your conventional weapons to strike a blow. However, a weapon\n" +
            "in your inventory only increases the maximum potential damage your attack could do. The Bomb acts\n" +
            "the same, except it has the greatest chance of killing a Goblin in a single turn. But, you can only\n" +
            "use a Bomb if it is in your inventory. Don't worry, Goblins will drop their Bombs if they are killed,\n" +
            "and have any in their inventory. Healing Mushrooms are used to add 25 health points, or top off your\n" +
            "health to 100. You can also only use them if one is in your inventory. Finally, the Potion is used to\n" +
            "take 25 health points of the Goblin's health and add to the Human's health. It can even be used to \n" +
            "increase the Human's maximum hit points. This item can also only be used if it is in the inventory.\n" +
            "Be careful with your special items, because only one of each item can be stored at a time! You can\n" +
            "relax knowing that Goblins cannot carry Healing Mushrooms or Potions, and they are limited to using\n" +
            "a sword, and have one bomb each. \n" + "\nThe game is won by killing all the Goblins, and the game is lost\n" +
            "when the Human is killed. Good luck, and thanks for playing the game!\n";

    static JPanel gameBoard;

    static JLabel[][] labels = new JLabel[10][10];

    static JLabel[] playerStats = new JLabel[4];

    static Border blue = BorderFactory.createLineBorder(Color.BLUE, 5), red = BorderFactory.createLineBorder(Color.RED, 5), orange = BorderFactory.createLineBorder(Color.ORANGE, 5), green = BorderFactory.createLineBorder(Color.GREEN, 5);

    public static void initialSetup()
    {

        goblins.put(1, goblin1);
        goblins.put(2, goblin2);
        goblins.put(3, goblin3);
        goblins.put(4, goblin4);
        goblins.put(5, goblin5);

        for (int i = 0; i < game.length; i++)
        {
            for (int j = 0; j < game[i].length; j++)
            {
                game[i][j] = new Land().toString();
            }
        }

        game[goblin1.getPosY()][goblin1.getPosX()] = goblin1.toString();
        game[goblin2.getPosY()][goblin2.getPosX()] = goblin2.toString();
        game[goblin3.getPosY()][goblin3.getPosX()] = goblin3.toString();
        game[goblin4.getPosY()][goblin4.getPosX()] = goblin4.toString();
        game[goblin5.getPosY()][goblin5.getPosX()] = goblin5.toString();

        game[Human.getPosY()][Human.getPosX()] = human.toString();

        //main frame
        JFrame gameFrame = new JFrame("Humans vs. Goblins");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(600, 600);

        //main board
        gameBoard = new JPanel();
        gameBoard.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                JLabel label = new JLabel();
                labels[i][j] = label;
                String labelType = game[i][j];
                switch (labelType){
                    case "H":
                        label.setBorder(blue);
                        break;
                    case "G":
                        label.setBorder(red);
                        break;
                    case "T":
                        label.setBorder(orange);
                        break;
                    case "L":
                        label.setBorder(green);
                        break;
                }
                labels[i][j].setText(game[i][j]);
                gameBoard.add(label);
            }
        }
        gameBoard.setSize(600, 500);

        //player panel
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.PAGE_AXIS));
        playerPanel.setSize(600, 100);
        JPanel playerInfo = new JPanel();
        JPanel playerInventory = new JPanel();
        playerInfo.setLayout(new GridLayout(1, 6, 10, 0));
        playerInventory.setLayout(new FlowLayout());

        JLabel position = new JLabel("Position: ");
        JLabel positionNum = new JLabel();
        playerStats[0] = positionNum;
        positionNum.setText((Human.getPosX() + 1) + ", " + (Human.getPosY() + 1));
        playerInfo.add(position);
        playerInfo.add(playerStats[0]);

        JLabel health = new JLabel("Health: ");
        JLabel healthNum = new JLabel();
        playerStats[1] = healthNum;
        healthNum.setText(String.valueOf(Human.getHealth()));
        playerInfo.add(health);
        playerInfo.add(playerStats[1]);

        JLabel power = new JLabel("Power: ");
        JLabel powerNum = new JLabel();
        playerStats[2] = powerNum;
        powerNum.setText(String.valueOf(Human.getPower()));
        playerInfo.add(power);
        playerInfo.add(playerStats[2]);

        JLabel inventory = new JLabel("Inventory: ");
        JLabel weapons = new JLabel();
        playerStats[3] = weapons;
        StringBuilder temp = new StringBuilder();
        for (int wep : Human.inventory.keySet())
        {
            temp.append(Human.inventory.get(wep).getWeapon()).append("     ");
        }
        weapons.setText(temp.toString());
        playerInventory.add(inventory);
        playerInventory.add(weapons);

        playerPanel.add(playerInfo);
        playerPanel.add(playerInventory);

        gameFrame.getContentPane().add(BorderLayout.CENTER, gameBoard);
        gameFrame.getContentPane().add(BorderLayout.SOUTH, playerPanel);
        gameFrame.setVisible(true);
    }

    public static void playerMove()
    {
        int x = Human.getPosX(), y = Human.getPosY();
        boolean done = false;
        while (!done) {
            String[] options = {"North", "South", "East", "West"};
            int choice = JOptionPane.showOptionDialog(new JFrame(), "What do you want to do?", "Your turn",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    if (Human.getPosY() != 0)
                    {
                        if (!game[Human.getPosY() - 1][Human.getPosX()].equals("G"))
                        {
                            Human.setPosY(Human.getPosY() - 1);
                            done = true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "A Goblin is in the way!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "Out of bounds!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 1:
                    if (Human.getPosY() != 9)
                    {
                        if (!game[Human.getPosY() + 1][Human.getPosX()].equals("G"))
                        {
                            Human.setPosY(Human.getPosY() + 1);
                            done = true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "A Goblin is in the way!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "Out of bounds!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 2:
                    if (Human.getPosX() != 9)
                    {
                        if (!game[Human.getPosY()][Human.getPosX() + 1].equals("G"))
                        {
                            Human.setPosX(Human.getPosX() + 1);
                            done = true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "A Goblin is in the way!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "Out of bounds!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 3:
                    if (Human.getPosX() != 0)
                    {
                        if (!game[Human.getPosY()][Human.getPosX() - 1].equals("G"))
                        {
                            Human.setPosX(Human.getPosX() - 1);
                            done = true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "A Goblin is in the way!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "Out of bounds!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
            }
        }
        game[Human.getPosY()][Human.getPosX()] = human.toString();
        game[y][x] = "L";
        printBoard();
    }

    public static void playerTurn()
    {
        boolean done = false;
        while(!done) {

            String[] options = {"Attack", "Heal", "Move", "Help", "Exit"};
            int choice = JOptionPane.showOptionDialog(new JFrame(), "What do you want to do?", "Your turn",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    int tempX = Human.getPosX(), tempY = Human.getPosY();
                    if (Human.isInCorner())
                    {
                        if (tempY == 9 && tempX == 9)
                        {
                            if (game[tempY][tempX - 1].equals("G"))
                            {
                                attackObject(tempY, tempX - 1);
                                done = true;
                                break;
                            }
                            else if (game[tempY - 1][tempX].equals("G"))
                            {
                                attackObject(tempY - 1, tempX);
                                done = true;
                                break;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(new JFrame(), "You're out of range to attack!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
                        }
                        else if (tempY == 0 && tempX == 0)
                        {
                            if (game[tempY][tempX + 1].equals("G"))
                            {
                                attackObject(tempY, tempX + 1);
                                done = true;
                                break;
                            }
                            else if (game[tempY + 1][tempX].equals("G"))
                            {
                                attackObject(tempY + 1, tempX);
                                done = true;
                                break;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(new JFrame(), "You're out of range to attack!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
                        }
                        else if (tempY == 9 && tempX == 0)
                        {
                            if (game[tempY - 1][tempX].equals("G"))
                            {
                                attackObject(tempY - 1, tempX);
                                done = true;
                                break;
                            }
                            else if (game[tempY][tempX + 1].equals("G"))
                            {
                                attackObject(tempY, tempX + 1);
                                done = true;
                                break;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(new JFrame(), "You're out of range to attack!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
                        }
                        else if (tempY == 0 && tempX == 9)
                        {
                            if (game[tempY + 1][tempX].equals("G"))
                            {
                                attackObject(tempY + 1, tempX);
                                done = true;
                                break;
                            }
                            else if (game[tempY][tempX - 1].equals("G"))
                            {
                                attackObject(tempY, tempX - 1);
                                done = true;
                                break;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(new JFrame(), "You're out of range to attack!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
                        }
                    }
                    else if (Human.isOnEdge())
                    {
                        if (Human.getPosY() == 9)
                        {
                            if (game[tempY - 1][tempX].equals("G"))
                            {
                                attackObject(tempY - 1, tempX);
                                done = true;
                                break;
                            }
                            else if (game[tempY][tempX - 1].equals("G"))
                            {
                                attackObject(tempY, tempX - 1);
                                done = true;
                                break;
                            }
                            else if (game[tempY][tempX + 1].equals("G"))
                            {
                                attackObject(tempY, tempX + 1);
                                done = true;
                                break;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(new JFrame(), "You're out of range to attack!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                        }
                        else if (Human.getPosY() == 0)
                        {
                            if (game[tempY + 1][tempX].equals("G"))
                            {
                                attackObject(tempY + 1, tempX);
                                done = true;
                                break;
                            }
                            else if (game[tempY][tempX - 1].equals("G"))
                            {
                                attackObject(tempY, tempX - 1);
                                done = true;
                                break;
                            }
                            else if (game[tempY][tempX + 1].equals("G"))
                            {
                                attackObject(tempY, tempX + 1);
                                done = true;
                                break;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(new JFrame(), "You're out of range to attack!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                        }
                        else if (Human.getPosX() == 9)
                        {
                            if (game[tempY][tempX - 1].equals("G"))
                            {
                                attackObject(tempY, tempX - 1);
                                done = true;
                                break;
                            }
                            else if (game[tempY - 1][tempX].equals("G"))
                            {
                                attackObject(tempY - 1, tempX);
                                done = true;
                                break;
                            }
                            else if (game[tempY + 1][tempX].equals("G"))
                            {
                                attackObject(tempY + 1, tempX);
                                done = true;
                                break;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(new JFrame(), "You're out of range to attack!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                        }
                        else if (Human.getPosX() == 0)
                        {
                            if (game[tempY][tempX + 1].equals("G"))
                            {
                                attackObject(tempY, tempX + 1);
                                done = true;
                                break;
                            }
                            else if (game[tempY - 1][tempX].equals("G"))
                            {
                                attackObject(tempY - 1, tempX);
                                done = true;
                                break;
                            }
                            else if (game[tempY + 1][tempX].equals("G"))
                            {
                                attackObject(tempY + 1, tempX);
                                done = true;
                                break;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(new JFrame(), "You're out of range to attack!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                        }
                    }
                    else
                    {
                        if (game[tempY][tempX + 1].equals("G"))
                        {
                            attackObject(tempY, tempX + 1);
                            done = true;
                            break;
                        }
                        else if (game[tempY][tempX - 1].equals("G"))
                        {
                            attackObject(tempY, tempX - 1);
                            done = true;
                            break;
                        }
                        else if (game[tempY + 1][tempX].equals("G"))
                        {
                            attackObject(tempY + 1, tempX);
                            done = true;
                            break;
                        }
                        else if (game[tempY - 1][tempX].equals("G"))
                        {
                            attackObject(tempY - 1, tempX);
                            done = true;
                            break;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "You're out of range to attack!", "Invalid move", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    }
                case 1:
                    int temp = Human.getHealth();
                    Human.heal();
                    if (Human.getHealth() > temp)
                    {
                        done = true;
                    }
                    break;
                case 2:
                    playerMove();
                    tempX = Human.getPosX();
                    tempY = Human.getPosY();

                    if (Human.isInCorner())
                    {
                        if (tempY == 9 && tempX == 9)
                        {
                            if (game[tempY][tempX - 1].equals("G"))
                            {
                                attackObject(tempY, tempX - 1);
                                done = true;
                                break;
                            }
                            else if (game[tempY - 1][tempX].equals("G"))
                            {
                                attackObject(tempY - 1, tempX);
                                done = true;
                                break;
                            }
                            else if ((game[Human.getPosY() - 1][Human.getPosX()].equals("T")) || (game[Human.getPosY()][Human.getPosX() - 1].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                Human.addWeapon(new Items(weapon));

                                if (game[tempY - 1][tempX].equals("T"))
                                {
                                    game[tempY - 1][tempX] = "L";
                                }
                                else if (game[tempY][tempX - 1].equals("T"))
                                {
                                    game[tempY][tempX - 1] = "L";
                                }
                                printBoard();
                                done = true;
                                break;
                            }
                            break;
                        }
                        else if (tempY == 0 && tempX == 0)
                        {
                            if (game[tempY][tempX + 1].equals("G"))
                            {
                                attackObject(tempY, tempX + 1);
                                done = true;
                                break;
                            }
                            else if (game[tempY + 1][tempX].equals("G"))
                            {
                                attackObject(tempY + 1, tempX);
                                done = true;
                                break;
                            }
                            else if ((game[tempY + 1][tempX].equals("T")) || (game[tempY][tempX + 1].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                Human.addWeapon(new Items(weapon));

                                if (game[tempY + 1][tempX].equals("T"))
                                {
                                    game[tempY + 1][tempX] = "L";
                                }
                                else if (game[tempY][tempX + 1].equals("T"))
                                {
                                    game[tempY][tempX + 1] = "L";
                                }
                                printBoard();
                                done = true;
                                break;
                            }
                            break;
                        }
                        else if (tempY == 9 && tempX == 0)
                        {
                            if (game[tempY - 1][tempX].equals("G"))
                            {
                                attackObject(tempY - 1, tempX);
                                done = true;
                                break;
                            }
                            else if (game[tempY][tempX + 1].equals("G"))
                            {
                                attackObject(tempY, tempX + 1);
                                done = true;
                                break;
                            }
                            else if ((game[tempY - 1][tempX].equals("T")) || (game[tempY][tempX + 1].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                Human.addWeapon(new Items(weapon));

                                if (game[tempY - 1][tempX].equals("T"))
                                {
                                    game[tempY - 1][tempX] = "L";
                                }
                                else if (game[tempY][tempX + 1].equals("T"))
                                {
                                    game[tempY][tempX + 1] = "L";
                                }
                                printBoard();
                                done = true;
                                break;
                            }
                            break;
                        }
                        else if (tempY == 0 && tempX == 9)
                        {
                            if (game[tempY + 1][tempX].equals("G"))
                            {
                                attackObject(tempY + 1, tempX);
                                done = true;
                                break;
                            }
                            else if (game[tempY][tempX - 1].equals("G"))
                            {
                                attackObject(tempY, tempX - 1);
                                done = true;
                                break;
                            }
                            else if ((game[tempY + 1][tempX].equals("T")) || (game[tempY][tempX - 1].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                Human.addWeapon(new Items(weapon));

                                if (game[tempY + 1][tempX].equals("T"))
                                {
                                    game[tempY + 1][tempX] = "L";
                                }
                                else if (game[tempY][tempX - 1].equals("T"))
                                {
                                    game[tempY][tempX - 1] = "L";
                                }
                                printBoard();
                                done = true;
                                break;
                            }
                            break;
                        }
                    }
                    else if (Human.isOnEdge())
                    {
                        if (Human.getPosY() == 9)
                        {
                            if (game[tempY - 1][tempX].equals("G"))
                            {
                                attackObject(tempY - 1, tempX);
                                done = true;
                                break;
                            }
                            else if (game[tempY][tempX - 1].equals("G"))
                            {
                                attackObject(tempY, tempX - 1);
                                done = true;
                                break;
                            }
                            else if (game[tempY][tempX + 1].equals("G"))
                            {
                                attackObject(tempY, tempX + 1);
                                done = true;
                                break;
                            }
                            else if (game[tempY - 1][tempX].equals("T"))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                Human.addWeapon(new Items(weapon));

                                game[tempY][tempX + 1] = "L";
                                printBoard();
                                done = true;
                                break;
                            }
                            else if ((game[tempY][tempX + 1].equals("T")) || (game[tempY][tempX - 1].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                Human.addWeapon(new Items(weapon));

                                if (game[tempY + 1][tempX].equals("T"))
                                {
                                    game[Human.getPosY() + 1][Human.getPosX()] = "L";
                                }
                                else if (game[tempY - 1][tempX].equals("T"))
                                {
                                    game[tempY - 1][tempX] = "L";
                                }
                                printBoard();
                                done = true;
                                break;
                            }
                        }
                        else if (Human.getPosY() == 0)
                        {
                            if (game[tempY + 1][tempX].equals("G"))
                            {
                                attackObject(tempY + 1, tempX);
                                done = true;
                                break;
                            }
                            else if (game[tempY][tempX - 1].equals("G"))
                            {
                                attackObject(tempY, tempX - 1);
                                done = true;
                                break;
                            }
                            else if (game[tempY][tempX + 1].equals("G"))
                            {
                                attackObject(tempY, tempX + 1);
                                done = true;
                                break;
                            }
                            else if (game[Human.getPosY() + 1][Human.getPosX()].equals("T"))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                Human.addWeapon(new Items(weapon));

                                game[Human.getPosY()][Human.getPosX() + 1] = "L";
                                printBoard();
                                done = true;
                                break;
                            }
                            else if ((game[Human.getPosY()][Human.getPosX() + 1].equals("T")) || (game[Human.getPosY()][Human.getPosX() - 1].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                Human.addWeapon(new Items(weapon));

                                if (game[Human.getPosY() + 1][Human.getPosX()].equals("T"))
                                {
                                    game[Human.getPosY() + 1][Human.getPosX()] = "L";
                                }
                                else if (game[Human.getPosY() - 1][Human.getPosX()].equals("T"))
                                {
                                    game[Human.getPosY() - 1][Human.getPosX()] = "L";
                                }
                                printBoard();
                                done = true;
                                break;
                            }
                        }
                        else if (Human.getPosX() == 9)
                        {
                            if (game[tempY][tempX - 1].equals("G"))
                            {
                                attackObject(tempY, tempX - 1);
                                done = true;
                                break;
                            }
                            else if (game[tempY - 1][tempX].equals("G"))
                            {
                                attackObject(tempY - 1, tempX);
                                done = true;
                                break;
                            }
                            else if (game[tempY + 1][tempX].equals("G"))
                            {
                                attackObject(tempY + 1, tempX);
                                done = true;
                                break;
                            }
                            else if ((game[Human.getPosY()][Human.getPosX() - 1].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                Human.addWeapon(new Items(weapon));

                                game[Human.getPosY()][Human.getPosX() - 1] = "L";
                                printBoard();
                                done = true;
                                break;
                            }
                            else if ((game[Human.getPosY() + 1][Human.getPosX()].equals("T")) || (game[Human.getPosY() - 1][Human.getPosX()].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                Human.addWeapon(new Items(weapon));

                                if (game[Human.getPosY() + 1][Human.getPosX()].equals("T"))
                                {
                                    game[Human.getPosY() + 1][Human.getPosX()] = "L";
                                }
                                else if (game[Human.getPosY() - 1][Human.getPosX()].equals("T"))
                                {
                                    game[Human.getPosY()- 1][Human.getPosX()] = "L";
                                }
                                printBoard();
                                done = true;
                                break;
                            }
                        }
                        else if (Human.getPosX() == 0)
                        {
                            if (game[tempY][tempX + 1].equals("G"))
                            {
                                attackObject(tempY, tempX + 1);
                                done = true;
                                break;
                            }
                            else if (game[tempY - 1][tempX].equals("G"))
                            {
                                attackObject(tempY - 1, tempX);
                                done = true;
                                break;
                            }
                            else if (game[tempY + 1][tempX].equals("G"))
                            {
                                attackObject(tempY + 1, tempX);
                                done = true;
                                break;
                            }
                            else if ((game[Human.getPosY()][Human.getPosX() + 1].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                Human.addWeapon(new Items(weapon));

                                game[Human.getPosY()][Human.getPosX() - 1] = "L";
                                printBoard();
                                done = true;
                                break;
                            }
                            else if ((game[Human.getPosY() + 1][Human.getPosX()].equals("T")) || (game[Human.getPosY() - 1][Human.getPosX()].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                Human.addWeapon(new Items(weapon));

                                if (game[Human.getPosY() + 1][Human.getPosX()].equals("T"))
                                {
                                    game[Human.getPosY() + 1][Human.getPosX()] = "L";
                                }
                                else if (game[Human.getPosY() - 1][Human.getPosX()].equals("T"))
                                {
                                    game[Human.getPosY()- 1][Human.getPosX()] = "L";
                                }
                                printBoard();
                                done = true;
                                break;
                            }
                        }
                    }
                    else
                    {
                        if (game[tempY][tempX + 1].equals("G"))
                        {
                            attackObject(tempY, tempX + 1);
                            done = true;
                            break;
                        }
                        else if (game[tempY][tempX - 1].equals("G"))
                        {
                            attackObject(tempY, tempX - 1);
                            done = true;
                            break;
                        }
                        else if (game[tempY + 1][tempX].equals("G"))
                        {
                            attackObject(tempY + 1, tempX);
                            done = true;
                            break;
                        }
                        else if (game[tempY - 1][tempX].equals("G"))
                        {
                            attackObject(tempY - 1, tempX);
                            done = true;
                            break;
                        }
                        else if ((game[Human.getPosY()][Human.getPosX() + 1].equals("T")) || (game[Human.getPosY()][Human.getPosX() - 1].equals("T")))
                        {
                            int weapon = (int)((Math.random() * (5)) + 0);
                            Human.addWeapon(new Items(weapon));

                            if (game[Human.getPosY()][Human.getPosX() + 1].equals("T"))
                            {
                                game[Human.getPosY()][Human.getPosX() + 1] = "L";
                            }
                            else if (game[Human.getPosY()][Human.getPosX() - 1].equals("T"))
                            {
                                game[Human.getPosY()][Human.getPosX() - 1] = "L";
                            }
                            printBoard();
                            done = true;
                            break;
                        }
                        else if ((game[Human.getPosY() + 1][Human.getPosX()].equals("T")) || (game[Human.getPosY() - 1][Human.getPosX()].equals("T")))
                        {
                            int weapon = (int)((Math.random() * (5)) + 0);
                            Human.addWeapon(new Items(weapon));

                            if (game[Human.getPosY() + 1][Human.getPosX()].equals("T"))
                            {
                                game[Human.getPosY() + 1][Human.getPosX()] = "L";
                            }
                            else if (game[Human.getPosY() - 1][Human.getPosX()].equals("T"))
                            {
                                game[Human.getPosY() - 1][Human.getPosX()] = "L";
                            }
                            printBoard();
                            done = true;
                            break;
                        }
                        done = true;
                        break;
                    }
                case 3:
                    JOptionPane.showMessageDialog(new JFrame(), helpStr);
                    break;
                case 4:
                    System.exit(-1);
            }
        }
    }

    public static void goblinTurn()
    {
        JOptionPane.showMessageDialog(new JFrame(), "Goblin's turn!");

        ArrayList<Integer> gobRemove = new ArrayList<>();
        boolean humanAttack = false;
        for (Goblin gob : goblins.values())
        {
            int x = gob.getPosX(), y = gob.getPosY();

            if ((x == Human.getPosX()) && ((y == Human.getPosY() - 1) || (y == Human.getPosY() + 1)))
            {
                gob.attack();
                if (Human.getHealth() <= 0)
                {
                    break;
                }
                else if (!humanAttack)
                {
                    Human.attack(gob);
                    generateTreasure();
                    humanAttack = true;
                }
            }
            else if ((y == Human.getPosY()) && ((x == Human.getPosX() - 1) || (x == Human.getPosX() + 1)))
            {
                gob.attack();
                if (Human.getHealth() <= 0)
                {
                    break;
                }
                else if (!humanAttack)
                {
                    Human.attack(gob);
                    generateTreasure();
                    humanAttack = true;
                }
            }
            else
            {
                if (y == Human.getPosY())
                {
                    if (x > Human.getPosX())
                    {
                        if (!game[y][x - 1].equals("G") && !game[y][x - 1].equals("T") && x != 0)
                        {
                            gob.setPosX(x - 1);
                            game[gob.getPosY()][gob.getPosX()] = gob.toString();
                            game[y][x] = "L";
                        }
                    }
                    else
                    {
                        if (!game[y][x + 1].equals("G") && !game[y][x + 1].equals("T") && x != 9)
                        {
                            gob.setPosX(x + 1);
                            game[gob.getPosY()][gob.getPosX()] = gob.toString();
                            game[y][x] = "L";
                        }
                    }
                }
                else if (x == Human.getPosX())
                {
                    if (y > Human.getPosY())
                    {
                        if (!game[y - 1][x].equals("G") && !game[y - 1][x].equals("T") && y != 0)
                        {
                            gob.setPosY(y - 1);
                            game[gob.getPosY()][gob.getPosX()] = gob.toString();
                            game[y][x] = "L";
                        }
                    }
                    else
                    {
                        if (!game[y + 1][x].equals("G") && !game[y + 1][x].equals("T") && y != 9)
                        {
                            gob.setPosY(y + 1);
                            game[gob.getPosY()][gob.getPosX()] = gob.toString();
                            game[y][x] = "L";
                        }
                    }
                }
                else
                {
                    int gobTempX, gobTempY;

                    gobTempX = gob.getPosX();
                    gobTempY = gob.getPosY();

                    int move = ((Math.random() <= 0.5) ? 1 : 2);

                    if (move == 1)
                    {
                        if ((gobTempX > Human.getPosX()) && gobTempX > 0)
                        {
                            if (!game[gob.getPosY()][gob.getPosX() - 1].equals("G") && !game[gob.getPosY()][gob.getPosX() - 1].equals("T"))
                            {
                                gob.setPosX(gob.getPosX() - 1);
                                game[gob.getPosY()][gob.getPosX()] = gob.toString();
                                game[y][x] = "L";
                            }
                        }
                        else if ((gobTempX < Human.getPosX()) && gobTempX < 9)
                        {
                            if (!game[gob.getPosY()][gob.getPosX() + 1].equals("G") && !game[gob.getPosY()][gob.getPosX() + 1].equals("T"))
                            {
                                gob.setPosX(gob.getPosX() + 1);
                                game[gob.getPosY()][gob.getPosX()] = gob.toString();
                                game[y][x] = "L";
                            }
                        }
                    }
                    else
                    {
                        if ((gobTempY > Human.getPosY()) && gobTempY > 0)
                        {
                            if (!game[gob.getPosY() - 1][gob.getPosX()].equals("G") && !game[gob.getPosY() - 1][gob.getPosX()].equals("T"))
                            {
                                gob.setPosY(gob.getPosY() - 1);
                                game[gob.getPosY()][gob.getPosX()] = gob.toString();
                                game[y][x] = "L";
                            }
                        }
                        else if ((gobTempY < Human.getPosY()) && gobTempY < 9)
                        {
                            if (!game[gob.getPosY() + 1][gob.getPosX()].equals("G") && !game[gob.getPosY() + 1][gob.getPosX()].equals("T"))
                            {
                                gob.setPosY(gob.getPosY() + 1);
                                game[gob.getPosY()][gob.getPosX()] = gob.toString();
                                game[y][x] = "L";
                            }
                        }
                    }
                }
                printBoard();

                if ((gob.getPosX() == Human.getPosX()) && ((gob.getPosY() == Human.getPosY() + 1) || (gob.getPosY() == Human.getPosY() - 1)))
                {
                    int goblin = 0;
                    for (int gobs : goblins.keySet())
                    {
                        if ((gob.getPosY() == goblins.get(gobs).getPosY()) && (gob.getPosX() == goblins.get(gobs).getPosX()))
                        {
                            goblin = gobs;
                            break;
                        }
                    }
                    gob.attack();
                    if (Human.getHealth() <= 0)
                    {
                        game[Human.getPosY()][Human.getPosX()] = "L";
                        break;
                    }
                    else if (!humanAttack)
                    {
                        Human.attack(gob);
                        if (gob.getHealth() <= 0)
                        {
                            game[gob.getPosY()][gob.getPosX()] = "L";
                            gobRemove.add(goblin);
                        }
                        generateTreasure();
                        humanAttack = true;
                    }
                }
                else if ((gob.getPosY() == Human.getPosY()) && ((gob.getPosX() == Human.getPosX() + 1) || (gob.getPosX() == gob.getPosX() - 1)))
                {
                    int goblin = 0;
                    for (int gobs : goblins.keySet())
                    {
                        if ((gob.getPosY() == goblins.get(gobs).getPosY()) && (gob.getPosX() == goblins.get(gobs).getPosX()))
                        {
                            goblin = gobs;
                            break;
                        }
                    }
                    gob.attack();
                    if (Human.getHealth() <= 0)
                    {
                        game[Human.getPosY()][Human.getPosX()] = "L";
                        break;
                    }
                    else if (!humanAttack)
                    {
                        Human.attack(gob);
                        if (gob.getHealth() <= 0)
                        {
                            game[gob.getPosY()][gob.getPosX()] = "L";
                            gobRemove.add(goblin);
                        }
                        generateTreasure();
                        humanAttack = true;
                    }
                }
            }
        }
        if (!gobRemove.isEmpty())
        {
            for (int remove : gobRemove)
            {
                goblins.remove(remove);
            }
            printBoard();
        }
    }

    public static void attackObject(int y, int x)
    {
        for (Goblin gob : goblins.values())
        {
            int index = 0;
            if ((gob.getPosY() == y) && (gob.getPosX() == x))
            {
                for (int keys : goblins.keySet())
                {
                    if ((gob.getPosY() == goblins.get(keys).getPosY()) && (gob.getPosX() == goblins.get(keys).getPosX()))
                    {
                        index = keys;
                        break;
                    }
                }
                if (Human.attack(gob))
                {
                    if (gob.getHealth() > 0) {
                        gob.attack();
                        generateTreasure();
                    } else {
                        if (gob.inventory.containsKey(4))
                        {
                            Human.addWeapon(new Items(4));
                        }
                        game[gob.getPosY()][gob.getPosX()] = "L";
                        goblins.remove(index);
                        generateTreasure();
                        printBoard();
                    }
                }
                else
                {
                    break;
                }
                break;
            }
        }
    }

    public static void printBoard()
    {
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                labels[i][j].setText(game[i][j]);
                String labelType = game[i][j];
                switch (labelType){
                    case "H":
                        labels[i][j].setBorder(blue);
                        break;
                    case "G":
                        labels[i][j].setBorder(red);
                        break;
                    case "T":
                        labels[i][j].setBorder(orange);
                        break;
                    case "L":
                        labels[i][j].setBorder(green);
                        break;
                }
            }
        }

        playerStats[0].setText((Human.getPosX() + 1) + ", " + (Human.getPosY() + 1));
        playerStats[1].setText(String.valueOf(Human.getHealth()));
        playerStats[2].setText(String.valueOf(Human.getPower()));
        StringBuilder temp = new StringBuilder();
        for (int wep : Human.inventory.keySet())
        {
            temp.append(Human.inventory.get(wep).getWeapon()).append("     ");
        }
        playerStats[3].setText(temp.toString());
    }

    public static void generateTreasure()
    {
        boolean valid = false;
        while(!valid)
        {
            int numX = (int) ((Math.random() * (8 - 1)) + 1);
            int numY = (int) ((Math.random() * (8 - 1)) + 1);
            if ((!game[numY][numX].equals("G")) || (!game[numY][numX].equals("H"))) {
                game[numY][numX] = "T";
                valid = true;
            }
        }
    }

    public static void playGame()
    {
        boolean done = false;
        initialSetup();

        while (!done)
        {
            if (!goblins.isEmpty() && Human.getHealth() > 0) {
                goblinTurn();
                if (!goblins.isEmpty() && Human.getHealth() > 0) {
                    playerTurn();

                    if (goblins.isEmpty()) {
                        JOptionPane.showMessageDialog(new JFrame(), "Congratulations! You beat the game!");
                        done = true;
                    } else if (Human.getHealth() == 0) {
                        JOptionPane.showMessageDialog(new JFrame(), "You died! Sorry, you lost!");
                        done = true;
                    }
                } else if (goblins.isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Congratulations! You beat the game!");
                    done = true;
                } else if (Human.getHealth() <= 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "You died! Sorry, you lost!");
                    done = true;
                }
            }
        }
        int finish = JOptionPane.showOptionDialog(new JFrame(), "Do you want to play again?", "Quit Game",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Yes", "No"},
                JOptionPane.YES_OPTION);

        if (finish == JOptionPane.YES_OPTION)
        {
            playGame();
        }
        else if (finish == JOptionPane.NO_OPTION)
        {
            System.exit(-1);
        }
    }

    public static void main(String[] args)
    {
        playGame();
    }
}
