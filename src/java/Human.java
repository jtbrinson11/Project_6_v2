import java.util.HashMap;
import java.util.Scanner;

public class Human{

    Scanner scan = new Scanner(System.in);

    HashMap<Integer, Items> inventory = new HashMap<>();

    private int health = 100;
    private int power = 0;
    private int posX = 0, posY = 0;

    public void setHealth(int num)
    {
        health = num;
    }

    public int getHealth()
    {
        return health;
    }

    public void setPower(int num)
    {
        power = num;
    }

    public int getPower()
    {
        return power;
    }

    public void setPosX(int num)
    {
        posX = num;
    }

    public int getPosX()
    {
        return posX;
    }

    public void setPosY(int num)
    {
        posY = num;
    }

    public int getPosY()
    {
        return posY;
    }

    public boolean isInCorner()
    {
        return (posX == 9 && posY == 9) || (posX == 0 && posY == 0) || (posX == 9 && posY == 0) || (posX == 0 && posY == 9);
    }

    public boolean isOnEdge()
    {
        return ((posX == 9) || (posX == 0) || (posY == 9) || (posY == 0));
    }

    public void addWeapon(Items add)
    {
        if (!inventory.containsKey(add.getWeaponID()))
        {
            inventory.put(add.getWeaponID(), add);
            setPower(getPower() + add.getWeaponPower());
            try
            {
                System.out.println("\nYou picked up the " + add.getWeapon() + "\n");
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                System.out.println("\nError in program . . .");
                System.exit(-1);
            }
        }
        else
        {
            try
            {
                System.out.println("\nThe " + add.getWeapon() + " is already in your inventory!\n");
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                System.out.println("\nError in program . . .");
                System.exit(-1);
            }
        }
    }

    public boolean attack(Goblin goblin)
    {
        System.out.println("\nAttack initiated!");
        boolean done = false, attacked = false;
        while (!done)
        {
            int choice;
            boolean valid = false;
            System.out.println("Options: \n1. Attack \n2. Use Healing Mushroom \n3. Use Bomb  \n4. Use Potion");
            System.out.println("\nEnter the number of the action you want to perform: ");
            try
            {
                choice = Integer.parseInt(scan.nextLine());
            }
            catch (Exception e)
            {
                System.out.println("Invalid input! Please try again!");
                continue;
            }

            if (choice != 1)
            {
                choice++;
            }

            for (int input : inventory.keySet()) {
                if (input == choice) {
                    valid = true;
                    break;
                }
            }
            int randNum;
            switch (choice) {
                case 1:
                    randNum = (int)((Math.random() * (getPower())) + 0);
                    goblin.setHealth(goblin.getHealth() - randNum);
                    if (goblin.getHealth() > 0)
                    {
                        try
                        {
                            System.out.println("\nThe Human attacked the Goblin! \nGoblin's health: " + goblin.getHealth());
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e)
                        {
                            System.out.println("\nError in program . . .");
                            System.exit(-1);
                        }
                    }
                    else
                    {
                        goblin = null;
                        System.gc();
                        try
                        {
                            System.out.println("\nThe Human attacked the Goblin and killed him!\n");
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e)
                        {
                            System.out.println("\nError in program . . .");
                            System.exit(-1);
                        }
                    }
                    attacked = true;
                    done = true;
                    break;
                case 3:
                    if (valid) {
                        if (getHealth() < 100)
                        {
                            setHealth(getHealth() + inventory.get(choice).getHealingAmount());
                            if (getHealth() > 100) {
                                int temp = getHealth() - 100;
                                setHealth(getHealth() - temp);
                            }
                            try
                            {
                                System.out.println("\nThe Human healed himself with a Healing mushroom! \nHuman's health: " + getHealth());
                                Thread.sleep(5000);
                            }
                            catch (InterruptedException e)
                            {
                                System.out.println("\nError in program . . .");
                                System.exit(-1);
                            }
                            inventory.remove(choice);
                            done = true;
                            attacked = true;
                        }
                        else
                        {
                            try
                            {
                                System.out.println("\nThe Human's health is at or greater than 100! Choose a different option!\n");
                                Thread.sleep(5000);
                            }
                            catch (InterruptedException e)
                            {
                                System.out.println("\nError in program . . .");
                                System.exit(-1);
                            }
                        }
                    }
                    else
                    {
                        try
                        {
                            System.out.println("\nThe Healing Mushroom is not in your inventory!\n");
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e)
                        {
                            System.out.println("\nError in program . . .");
                            System.exit(-1);
                        }
                    }
                    break;
                case 4:
                    if (valid) {
                        randNum = (int) ((Math.random() * (inventory.get(choice).getWeaponPower())) + 0);
                        goblin.setHealth(goblin.getHealth() - randNum);
                        if (goblin.getHealth() > 0) {
                            try
                            {
                                System.out.println("\nThe Human attacked the Goblin with a bomb! \nGoblin's health: " + goblin.getHealth());
                                Thread.sleep(5000);
                            }
                            catch (InterruptedException e)
                            {
                                System.out.println("\nError in program . . .");
                                System.exit(-1);
                            }
                            setPower(getPower() - inventory.get(choice).getWeaponPower());
                            inventory.remove(choice);
                        } else {
                            goblin = null;
                            System.gc();
                            setPower(getPower() - inventory.get(choice).getWeaponPower());
                            inventory.remove(choice);
                            try
                            {
                                System.out.println("\nThe Human attacked the Goblin with a bomb and killed him!\n");
                                Thread.sleep(5000);
                            }
                            catch (InterruptedException e)
                            {
                                System.out.println("\nError in program . . .");
                                System.exit(-1);
                            }
                        }
                        attacked = true;
                        done = true;
                    }
                    else
                    {
                        try
                        {
                            System.out.println("\nThe Bomb is not in your inventory!\n");
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e)
                        {
                            System.out.println("\nError in program . . .");
                            System.exit(-1);
                        }
                    }
                    break;
                case 5:
                    if (valid) {
                        if (goblin.getHealth() >= 25) {
                            goblin.setHealth(goblin.getHealth() - inventory.get(choice).getHealingAmount());
                            setHealth(getHealth() + inventory.get(choice).getHealingAmount());
                            inventory.remove(choice);
                            try
                            {
                                System.out.println("\nThe Human used the potion to take 25 points of Goblin's health to add to his own! \nHuman's health: " + getHealth() + "\nGoblin's health: " + goblin.getHealth() + "\n");
                                Thread.sleep(5000);
                            }
                            catch (InterruptedException e)
                            {
                                System.out.println("\nError in program . . .");
                                System.exit(-1);
                            }
                        } else {
                            int health = goblin.getHealth();
                            goblin.setHealth(0);
                            setHealth(getHealth() + health);
                            goblin = null;
                            System.gc();
                            inventory.remove(choice);
                            try
                            {
                                System.out.println("\nThe Human used the potion to take the rest of Goblin's health, add to his own, and kill the Goblin! \nHuman's health: " + getHealth() + "\n");
                                Thread.sleep(5000);
                            }
                            catch (InterruptedException e)
                            {
                                System.out.println("\nError in program . . .");
                                System.exit(-1);
                            }
                        }
                        attacked = true;
                        done = true;
                    } else {
                        try
                        {
                            System.out.println("\nThe Potion is not in your inventory!\n");
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e)
                        {
                            System.out.println("\nError in program . . .");
                            System.exit(-1);
                        }
                        break;
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please try again!\n");
                    break;
                }
        }
        return attacked;
    }

    public boolean heal()
    {
        boolean healed = false;
        boolean exists = false;
        for (int check : inventory.keySet())
        {
            if (check == 3)
            {
                exists = true;
                break;
            }
        }
        if (exists)
        {
            if (getHealth() < 100)
            {
                setHealth(getHealth() + inventory.get(3).getHealingAmount());
                if (getHealth() > 100)
                {
                    int temp = getHealth() - 100;
                    setHealth(getHealth() - temp);
                    healed = true;
                }
                inventory.remove(3);
                try
                {
                    System.out.println("\nThe Human healed himself with a Healing mushroom! \nHuman's health: " + getHealth());
                    Thread.sleep(5000);
                }
                catch (InterruptedException e)
                {
                    System.out.println("\nError in program . . .");
                    System.exit(-1);
                }
            }
            else
            {
                try
                {
                    System.out.println("\nThe human's health is already full!");
                    Thread.sleep(5000);
                }
                catch (InterruptedException e)
                {
                    System.out.println("\nError in program . . .");
                    System.exit(-1);
                }
            }
        }
        else
        {
            try
            {
                System.out.println("\nThe Healing Mushroom is not in the Human's inventory!");
                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
                System.out.println("\nError in program . . .");
                System.exit(-1);
            }
        }
        return healed;
    }

    public String toString()
    {
        return "H";
    }

    public Human(int x, int y)
    {
        addWeapon(new Items(1));
        addWeapon(new Items(3));
        addWeapon(new Items(4));
        addWeapon(new Items(5));
        setPosX(x);
        setPosY(y);
    }
}
