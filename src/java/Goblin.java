import java.util.HashMap;

public class Goblin{

    HashMap<Integer, Items> inventory = new HashMap<>();

    private int health = 50;
    private int power = 135;

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

    public void attack(Human human)
    {
        System.out.println("\nAttack started by Goblin!");
        boolean done = false;
        while (!done) {
            int choice = ((Math.random() <= 0.5) ? 1 : 2);
            if (choice == 1) {
                human.setHealth((human.getHealth()) - (inventory.get(1).getWeaponPower()));
                if (human.getHealth() <= 0) {
                    try
                    {
                        System.out.println("\nThe Goblin killed the Human with his sword!\n");
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println("\nError in program . . .");
                        System.exit(-1);
                    }
                    human = null;
                    System.gc();
                }
                else
                {
                    try
                    {
                        System.out.println("\nThe Goblin injured the Human with his sword! \nHuman's health: " + human.getHealth() + "\n");
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println("\nError in program . . .");
                        System.exit(-1);
                    }
                }
                done = true;
            }
            else
            {
                if (inventory.size() != 1)
                {
                    int damage = (int)((Math.random() * (inventory.get(1).getWeaponPower())) + 0);
                    human.setHealth(human.getHealth() - damage);
                    if (human.getHealth() <= 0)
                    {
                        try
                        {
                            System.out.println("\nThe Goblin killed the Human with a bomb!\n");
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e)
                        {
                            System.out.println("\nError in program . . .");
                            System.exit(-1);
                        }
                        human = null;
                        System.gc();
                    }
                    else
                    {
                        try
                        {
                            System.out.println("\nThe Goblin injured the Human with a bomb! \nHuman's health: " + human.getHealth() + "\n");
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e)
                        {
                            System.out.println("\nError in program . . .");
                            System.exit(-1);
                        }
                    }
                    inventory.remove(4);
                    setPower(getPower() - 100);
                    done = true;
                }
            }
        }
    }

    public String toString()
    {
        return "G";
    }

    public Goblin(int x, int y)
    {
        inventory.put(1, new Items(1));
        inventory.put(4, new Items(4));
        setPosX(x);
        setPosY(y);
    }
}
