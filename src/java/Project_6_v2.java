import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Project_6_v2{

    static Scanner scan = new Scanner(System.in);
    static Scanner scan1 = new Scanner(System.in);
    static Scanner scan2 = new Scanner(System.in);

    public static String[][] game = new String[10][10];

    static Human human = new Human(5, 9);

    static HashMap<Integer, Goblin> goblins = new HashMap<>();

    static Goblin goblin1 = new Goblin(0,0);

    static Goblin goblin2 = new Goblin(2,0);

    static Goblin goblin3 = new Goblin(4,0);

    static Goblin goblin4 = new Goblin(6,0);

    static Goblin goblin5 = new Goblin(8,0);

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

        game[human.getPosY()][human.getPosX()] = human.toString();
    }

    public static void playerStats()
    {
        int tempX = human.getPosX() + 1, tempY = human.getPosY() + 1;
        System.out.print("Position: (" + tempX + "," + tempY + ")   Health: (" + human.getHealth() + ")   Power: (" + human.getPower() + ")\n");
    }

    public static void playerMove()
    {
        int x = human.getPosX(), y = human.getPosY();
        boolean done = false;
        while (!done) {
            System.out.println("\nWhich way do you want to move (n/s/e/w): ");
            String move = scan1.nextLine();
            switch (move) {
                case "N":
                    if (human.getPosY() != 0)
                    {
                        if (!game[human.getPosY() - 1][human.getPosX()].equals("G"))
                        {
                            human.setPosY(human.getPosY() - 1);
                            done = true;
                        }
                        else
                        {
                            System.out.println("A Goblin is in the way! PLease try again!");
                        }
                    }
                    else
                    {
                        System.out.println("That's out of bounds. Please try again!");
                    }
                    break;
                case "n":
                    if (human.getPosY() != 0)
                    {
                        if (!game[human.getPosY() - 1][human.getPosX()].equals("G"))
                        {
                            human.setPosY(human.getPosY() - 1);
                            done = true;
                        }
                        else
                        {
                            System.out.println("A Goblin is blocking the way! PLease try again!");
                        }
                    }
                    else
                    {
                        System.out.println("Sorry, that's too far north. Please try again!");
                    }
                    break;
                case "S":
                    if (human.getPosY() != 9)
                    {
                        if (!game[human.getPosY() + 1][human.getPosX()].equals("G"))
                        {
                            human.setPosY(human.getPosY() + 1);
                            done = true;
                        }
                        else
                        {
                            System.out.println("A Goblin is in the way! Please try again!");
                        }
                    }
                    else
                    {
                        System.out.println("Sorry, that's out of bounds. Please try again!");
                    }
                    break;
                case "s":
                    if (human.getPosY() != 9)
                    {
                        if (!game[human.getPosY() + 1][human.getPosX()].equals("G"))
                        {
                            human.setPosY(human.getPosY() + 1);
                            done = true;
                        }
                        else
                        {
                            System.out.println("A Goblin is blocking your path! Please try again!");
                        }
                    }
                    else
                    {
                        System.out.println("That's out of bounds. Please try again!");
                    }
                    break;
                case "E":
                    if (human.getPosX() != 9)
                    {
                        if (!game[human.getPosY()][human.getPosX() + 1].equals("G"))
                        {
                            human.setPosX(human.getPosX() + 1);
                            done = true;
                        }
                        else
                        {
                            System.out.println("There's a Goblin in the way! Please try again!");
                        }
                    }
                    else
                    {
                        System.out.println("Sorry, that's out of bounds. Please try again!");
                    }
                    break;
                case "e":
                    if (human.getPosX() != 9)
                    {
                        if (!game[human.getPosY()][human.getPosX() + 1].equals("G"))
                        {
                            human.setPosX(human.getPosX() + 1);
                            done = true;
                        }
                        else
                        {
                            System.out.println("There's a Goblin in the way! Please try again!");
                        }
                    }
                    else
                    {
                        System.out.println("That's too far east. Please try again!");
                    }
                    break;
                case "W":
                    if (human.getPosX() != 0)
                    {
                        if (!game[human.getPosY()][human.getPosX() - 1].equals("G"))
                        {
                            human.setPosX(human.getPosX() - 1);
                            done = true;
                        }
                        else
                        {
                            System.out.println("The Goblin is in the way! Please try again!");
                        }
                    }
                    else
                    {
                        System.out.println("Sorry, that's out of bounds. Please try again!");
                    }
                    break;
                case "w":
                    if (human.getPosX() != 0)
                    {
                        if (!game[human.getPosY()][human.getPosX() - 1].equals("G"))
                        {
                            human.setPosX(human.getPosX() - 1);
                            done = true;
                        }
                        else
                        {
                            System.out.println("A Goblin is in the way! Please try again!");
                        }
                    }
                    else
                    {
                        System.out.println("That's too far west. Please try again!");
                    }
                    break;
                default:
                    System.out.println("Sorry, invalid input! Try again!");
                    break;
            }
        }
        game[human.getPosY()][human.getPosX()] = human.toString();
        game[y][x] = "L";
        try
        {
            printBoard();
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            System.out.println("\nError in program . . .");
            System.exit(-1);
        }
    }

    public static void playerTurn()
    {
        System.out.println("\nIt's your turn. Here are the possible actions: ");
        System.out.println("\n1. Attack");
        System.out.println("2. Heal");
        System.out.println("3. Move");
        System.out.println("4. Help");

        boolean done = false;
        while(!done) {
            System.out.println("\n\nWhat do you want to do: ");
            String input = scan.nextLine();
            int choice = 0;
            try
            {
                choice = Integer.parseInt(input);
            } catch (Exception e)
            {
                System.out.println("Input was not a number!");
            }

            switch (choice) {
                case 1:
                    int tempX = human.getPosX(), tempY = human.getPosY();
                    if (human.isInCorner())
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
                                System.out.println("You're out of range to attack! PLease try again!");
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
                                System.out.println("You're out of range to attack! PLease try again!");
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
                                System.out.println("You're out of range to attack! PLease try again!");
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
                                System.out.println("You're out of range to attack! PLease try again!");
                            }
                            break;
                        }
                    }
                    else if (human.isOnEdge())
                    {
                        if (human.getPosY() == 9)
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
                                System.out.println("You're out of range to attack! PLease try again!");
                                break;
                            }
                        }
                        else if (human.getPosY() == 0)
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
                                System.out.println("You're out of range to attack! PLease try again!");
                                break;
                            }
                        }
                        else if (human.getPosX() == 9)
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
                                System.out.println("You're out of range to attack! PLease try again!");
                                break;
                            }
                        }
                        else if (human.getPosX() == 0)
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
                                System.out.println("You're out of range to attack! PLease try again!");
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
                            System.out.println("You're out of range to attack! PLease try again!");
                        }
                        break;
                    }
                case 2:
                    int temp = human.getHealth();
                    human.heal();
                    if (human.getHealth() > temp)
                    {
                        done = true;
                    }
                    break;
                case 3:
                    playerMove();
                    tempX = human.getPosX();
                    tempY = human.getPosY();

                    if (human.isInCorner())
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
                            else if ((game[human.getPosY() - 1][human.getPosX()].equals("T")) || (game[human.getPosY()][human.getPosX() - 1].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                human.addWeapon(new Items(weapon));

                                if (game[tempY - 1][tempX].equals("T"))
                                {
                                    game[tempY - 1][tempX] = "L";
                                }
                                else if (game[tempY][tempX - 1].equals("T"))
                                {
                                    game[tempY][tempX - 1] = "L";
                                }
                                try
                                {
                                    printBoard();
                                    Thread.sleep(5000);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println("\nError in program . . .");
                                    System.exit(-1);
                                }
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
                                human.addWeapon(new Items(weapon));

                                if (game[tempY + 1][tempX].equals("T"))
                                {
                                    game[tempY + 1][tempX] = "L";
                                }
                                else if (game[tempY][tempX + 1].equals("T"))
                                {
                                    game[tempY][tempX + 1] = "L";
                                }
                                try
                                {
                                    printBoard();
                                    Thread.sleep(5000);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println("\nError in program . . .");
                                    System.exit(-1);
                                }
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
                                human.addWeapon(new Items(weapon));

                                if (game[tempY - 1][tempX].equals("T"))
                                {
                                    game[tempY - 1][tempX] = "L";
                                }
                                else if (game[tempY][tempX + 1].equals("T"))
                                {
                                    game[tempY][tempX + 1] = "L";
                                }
                                try
                                {
                                    printBoard();
                                    Thread.sleep(5000);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println("\nError in program . . .");
                                    System.exit(-1);
                                }
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
                                human.addWeapon(new Items(weapon));

                                if (game[tempY + 1][tempX].equals("T"))
                                {
                                    game[tempY + 1][tempX] = "L";
                                }
                                else if (game[tempY][tempX - 1].equals("T"))
                                {
                                    game[tempY][tempX - 1] = "L";
                                }
                                try
                                {
                                    printBoard();
                                    Thread.sleep(5000);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println("\nError in program . . .");
                                    System.exit(-1);
                                }
                                done = true;
                                break;
                            }
                            break;
                        }
                    }
                    else if (human.isOnEdge())
                    {
                        if (human.getPosY() == 9)
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
                                human.addWeapon(new Items(weapon));

                                game[tempY][tempX + 1] = "L";
                                try
                                {
                                    printBoard();
                                    Thread.sleep(5000);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println("\nError in program . . .");
                                    System.exit(-1);
                                }
                                done = true;
                                break;
                            }
                            else if ((game[tempY][tempX + 1].equals("T")) || (game[tempY][tempX - 1].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                human.addWeapon(new Items(weapon));

                                if (game[tempY + 1][tempX].equals("T"))
                                {
                                    game[human.getPosY() + 1][human.getPosX()] = "L";
                                }
                                else if (game[tempY - 1][tempX].equals("T"))
                                {
                                    game[tempY - 1][tempX] = "L";
                                }
                                try
                                {
                                    printBoard();
                                    Thread.sleep(5000);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println("\nError in program . . .");
                                    System.exit(-1);
                                }
                                done = true;
                                break;
                            }
                        }
                        else if (human.getPosY() == 0)
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
                            else if (game[human.getPosY() + 1][human.getPosX()].equals("T"))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                human.addWeapon(new Items(weapon));

                                game[human.getPosY()][human.getPosX() + 1] = "L";
                                try
                                {
                                    printBoard();
                                    Thread.sleep(5000);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println("\nError in program . . .");
                                    System.exit(-1);
                                }
                                done = true;
                                break;
                            }
                            else if ((game[human.getPosY()][human.getPosX() + 1].equals("T")) || (game[human.getPosY()][human.getPosX() - 1].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                human.addWeapon(new Items(weapon));

                                if (game[human.getPosY() + 1][human.getPosX()].equals("T"))
                                {
                                    game[human.getPosY() + 1][human.getPosX()] = "L";
                                }
                                else if (game[human.getPosY() - 1][human.getPosX()].equals("T"))
                                {
                                    game[human.getPosY() - 1][human.getPosX()] = "L";
                                }
                                try
                                {
                                    printBoard();
                                    Thread.sleep(5000);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println("\nError in program . . .");
                                    System.exit(-1);
                                }
                                done = true;
                                break;
                            }
                        }
                        else if (human.getPosX() == 9)
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
                            else if ((game[human.getPosY()][human.getPosX() - 1].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                human.addWeapon(new Items(weapon));

                                game[human.getPosY()][human.getPosX() - 1] = "L";
                                try
                                {
                                    printBoard();
                                    Thread.sleep(5000);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println("\nError in program . . .");
                                    System.exit(-1);
                                }
                                done = true;
                                break;
                            }
                            else if ((game[human.getPosY() + 1][human.getPosX()].equals("T")) || (game[human.getPosY() - 1][human.getPosX()].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                human.addWeapon(new Items(weapon));

                                if (game[human.getPosY() + 1][human.getPosX()].equals("T"))
                                {
                                    game[human.getPosY() + 1][human.getPosX()] = "L";
                                }
                                else if (game[human.getPosY() - 1][human.getPosX()].equals("T"))
                                {
                                    game[human.getPosY()- 1][human.getPosX()] = "L";
                                }
                                try
                                {
                                    printBoard();
                                    Thread.sleep(5000);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println("\nError in program . . .");
                                    System.exit(-1);
                                }
                                done = true;
                                break;
                            }
                        }
                        else if (human.getPosX() == 0)
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
                            else if ((game[human.getPosY()][human.getPosX() + 1].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                human.addWeapon(new Items(weapon));

                                game[human.getPosY()][human.getPosX() - 1] = "L";
                                try
                                {
                                    printBoard();
                                    Thread.sleep(5000);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println("\nError in program . . .");
                                    System.exit(-1);
                                }
                                done = true;
                                break;
                            }
                            else if ((game[human.getPosY() + 1][human.getPosX()].equals("T")) || (game[human.getPosY() - 1][human.getPosX()].equals("T")))
                            {
                                int weapon = (int)((Math.random() * (5)) + 0);
                                human.addWeapon(new Items(weapon));

                                if (game[human.getPosY() + 1][human.getPosX()].equals("T"))
                                {
                                    game[human.getPosY() + 1][human.getPosX()] = "L";
                                }
                                else if (game[human.getPosY() - 1][human.getPosX()].equals("T"))
                                {
                                    game[human.getPosY()- 1][human.getPosX()] = "L";
                                }
                                try
                                {
                                    printBoard();
                                    Thread.sleep(5000);
                                }
                                catch (InterruptedException e)
                                {
                                    System.out.println("\nError in program . . .");
                                    System.exit(-1);
                                }
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
                        else if ((game[human.getPosY()][human.getPosX() + 1].equals("T")) || (game[human.getPosY()][human.getPosX() - 1].equals("T")))
                        {
                            int weapon = (int)((Math.random() * (5)) + 0);
                            human.addWeapon(new Items(weapon));

                            if (game[human.getPosY()][human.getPosX() + 1].equals("T"))
                            {
                                game[human.getPosY()][human.getPosX() + 1] = "L";
                            }
                            else if (game[human.getPosY()][human.getPosX() - 1].equals("T"))
                            {
                                game[human.getPosY()][human.getPosX() - 1] = "L";
                            }
                            try
                            {
                                printBoard();
                                Thread.sleep(5000);
                            }
                            catch (InterruptedException e)
                            {
                                System.out.println("\nError in program . . .");
                                System.exit(-1);
                            }
                            done = true;
                            break;
                        }
                        else if ((game[human.getPosY() + 1][human.getPosX()].equals("T")) || (game[human.getPosY() - 1][human.getPosX()].equals("T")))
                        {
                            int weapon = (int)((Math.random() * (5)) + 0);
                            human.addWeapon(new Items(weapon));

                            if (game[human.getPosY() + 1][human.getPosX()].equals("T"))
                            {
                                game[human.getPosY() + 1][human.getPosX()] = "L";
                            }
                            else if (game[human.getPosY() - 1][human.getPosX()].equals("T"))
                            {
                                game[human.getPosY() - 1][human.getPosX()] = "L";
                            }
                            try
                            {
                                printBoard();
                                Thread.sleep(5000);
                            }
                            catch (InterruptedException e)
                            {
                                System.out.println("\nError in program . . .");
                                System.exit(-1);
                            }
                            done = true;
                            break;
                        }
                        done = true;
                        break;
                    }
                case 4:
                    help();
                default:
                    System.out.println("Invalid input! Please try again!");
            }
        }
    }

    public static void goblinTurn()
    {
        ArrayList<Integer> gobRemove = new ArrayList<>();
        boolean humanAttack = false;
        for (Goblin gob : goblins.values())
        {
            int x = gob.getPosX(), y = gob.getPosY();

            if ((x == human.getPosX()) && ((y == human.getPosY() - 1) || (y == human.getPosY() + 1)))
            {
                gob.attack(human);
                if (human.getHealth() <= 0)
                {
                    break;
                }
                else if (!humanAttack)
                {
                    human.attack(gob);
                    generateTreasure();
                    humanAttack = true;
                }
            }
            else if ((y == human.getPosY()) && ((x == human.getPosX() - 1) || (x == human.getPosX() + 1)))
            {
                gob.attack(human);
                if (human.getHealth() <= 0)
                {
                    break;
                }
                else if (!humanAttack)
                {
                    human.attack(gob);
                    generateTreasure();
                    humanAttack = true;
                }
            }
            else
            {
                if (y == human.getPosY())
                {
                    if (x > human.getPosX())
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
                else if (x == human.getPosX())
                {
                    if (y > human.getPosY())
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
                        if ((gobTempX > human.getPosX()) && gobTempX > 0)
                        {
                            if (!game[gob.getPosY()][gob.getPosX() - 1].equals("G") && !game[gob.getPosY()][gob.getPosX() - 1].equals("T"))
                            {
                                gob.setPosX(gob.getPosX() - 1);
                                game[gob.getPosY()][gob.getPosX()] = gob.toString();
                                game[y][x] = "L";
                            }
                        }
                        else if ((gobTempX < human.getPosX()) && gobTempX < 9)
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
                        if ((gobTempY > human.getPosY()) && gobTempY > 0)
                        {
                            if (!game[gob.getPosY() - 1][gob.getPosX()].equals("G") && !game[gob.getPosY() - 1][gob.getPosX()].equals("T"))
                            {
                                gob.setPosY(gob.getPosY() - 1);
                                game[gob.getPosY()][gob.getPosX()] = gob.toString();
                                game[y][x] = "L";
                            }
                        }
                        else if ((gobTempY < human.getPosY()) && gobTempY < 9)
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
                try
                {
                    printBoard();
                    Thread.sleep(5000);
                }
                catch (InterruptedException e)
                {
                    System.out.println("\nError in program . . .");
                    System.exit(-1);
                }

                if ((gob.getPosX() == human.getPosX()) && ((gob.getPosY() == human.getPosY() + 1) || (gob.getPosY() == human.getPosY() - 1)))
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
                    gob.attack(human);
                    if (human.getHealth() <= 0)
                    {
                        game[human.getPosY()][human.getPosX()] = "L";
                        break;
                    }
                    else if (!humanAttack)
                    {
                        human.attack(gob);
                        if (gob.getHealth() <= 0)
                        {
                            game[gob.getPosY()][gob.getPosX()] = "L";
                            gobRemove.add(goblin);
                        }
                        generateTreasure();
                        humanAttack = true;
                    }
                }
                else if ((gob.getPosY() == human.getPosY()) && ((gob.getPosX() == human.getPosX() + 1) || (gob.getPosX() == gob.getPosX() - 1)))
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
                    gob.attack(human);
                    if (human.getHealth() <= 0)
                    {
                        game[human.getPosY()][human.getPosX()] = "L";
                        break;
                    }
                    else if (!humanAttack)
                    {
                        human.attack(gob);
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
            try
            {
                printBoard();
                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
                System.out.println("\nError in program . . .");
                System.exit(-1);
            }
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
                if (human.attack(gob))
                {
                    if (gob.getHealth() > 0) {
                        gob.attack(human);
                        generateTreasure();
                    } else {
                        if (gob.inventory.containsKey(4))
                        {
                            human.addWeapon(new Items(4));
                        }
                        game[gob.getPosY()][gob.getPosX()] = "L";
                        goblins.remove(index);
                        generateTreasure();
                        try
                        {
                            printBoard();
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e)
                        {
                            System.out.println("\nError in program . . .");
                            System.exit(-1);
                        }
                    }
                }
                break;
            }
        }
    }

    public static void help()
    {
        try
        {
            System.out.println("\nThis game is a turn based game where the Humans are trying to kill the Goblins,\n" +
                    "and vice versa. The Humans are represented by the letter H, the Goblins by letter G,\n" +
                    "and random treasure by the letter T. Keep an eye out for the treasure! \n");
            Thread.sleep(15000);
        }
        catch (InterruptedException e)
        {
            System.out.println("\nError in program . . .");
            System.exit(-1);
        }

        try
        {
            System.out.println("\nYou control the" +
                    " Human. The Goblins will automatically pursue and attempt to kill the Human when it's their turn, or choose to stay still.\n" +
                    "A prompt will display when it's your turn to move, and ask what you want to do. From there,\n" +
                    "you can move or access an inventory of items your character has. Movement is in\n" +
                    "a north/south/east/west direction. To move, simply type the first letter of the direction\n" +
                    "you want to move. Your inventory will contain all your items and weapons on hand.\n" +
                    "You can use the Healing Mushroom whenever you wish, but the other items are restricted for\n" +
                    "use in combat. \n");
            Thread.sleep(30000);
        }
        catch (InterruptedException e)
        {
            System.out.println("\nError in program . . .");
            System.exit(-1);
        }

        try
        {
            System.out.println("\nCombat in this game is automatically initiated when the Human and a Goblin\n" +
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
                    "a sword, and have one bomb each. \n");
            Thread.sleep(35000);
        }
        catch (InterruptedException e)
        {
            System.out.println("\nError in program . . .");
            System.exit(-1);
        }

        try
        {
            System.out.println("\nThe game is won by killing all the Goblins, and the game is lost\n" +
                    "when the Human is killed. Good luck, and thanks for playing the game!\n");
            Thread.sleep(15000);
        }
        catch (InterruptedException e)
        {
            System.out.println("\nError in program . . .");
            System.exit(-1);
        }
    }

    public static void printBoard()
    {
        System.out.println("\n");
        for (int i = 0; i < game.length; i++)
        {
            for (int j = 0; j < game[i].length; j++)
            {
                System.out.print(game[i][j] + "   ");
            }
            System.out.print("\n");
        }
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
        boolean done = false, finished = false;
        try
        {
            System.out.println("\nWelcome to Humans vs. Goblins");
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            System.out.println("\nError in program . . .");
            System.exit(-1);
        }
        help();
        while(!finished)
        {
            initialSetup();
            playerStats();
            printBoard();
            while (!done)
            {
                if (!goblins.isEmpty() && human.getHealth() > 0) {
                    try
                    {
                        System.out.println("\nGoblins turn!");
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println("\nError in program . . .");
                        System.exit(-1);
                    }
                    goblinTurn();
                    if (!goblins.isEmpty() && human.getHealth() > 0) {
                        playerTurn();

                        if (goblins.isEmpty()) {
                            System.out.println("Congratulations! You beat the game!");
                            done = true;
                        } else if (human.getHealth() == 0) {
                            System.out.println("You died! Sorry, you lost!");
                            done = true;
                        }
                    } else if (goblins.isEmpty()) {
                        System.out.println("Congratulations! You beat the game!");
                        done = true;
                    } else if (human.getHealth() <= 0) {
                        System.out.println("You died! Sorry, you lost!");
                        done = true;
                    }
                }
            }
            System.out.println("Do you want to play again (y/n): ");
            String input = "";
            try
            {
                input = scan2.nextLine();
            }
            catch (Exception e)
            {
                System.out.println("Sorry, that was invalid input! Please try again!");
            }
            switch (input)
            {
                case "Y":
                    System.out.println("Ok, I'll reset the game.\n");
                    done = false;
                    break;
                case "y":
                    System.out.println("I'll reset the game.\n");
                    done = false;
                    break;
                case "N":
                    System.out.println("Ok, good-bye for now.\n");
                    finished = true;
                    break;
                case "n":
                    System.out.println("Exiting the game.\n");
                    finished = true;
                    break;
                default:
                    System.out.println("I didn't understand. Exiting by default. . .");
                    finished = true;
                    break;
            }
        }
    }

    public static void main(String[] args)
    {
        playGame();
    }
}
