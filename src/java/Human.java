import java.util.HashMap;
import javax.swing.*;

public class Human{

    static HashMap<Integer, Items> inventory = new HashMap<>();

    private static int health = 100, power = 0, posX = 5, posY = 9;

    public static void setHealth(int num)
    {
        health = num;
    }

    public static int getHealth()
    {
        return health;
    }

    public static void setPower(int num)
    {
        power = num;
    }

    public static int getPower()
    {
        return power;
    }

    public static void setPosX(int num)
    {
        posX = num;
    }

    public static int getPosX()
    {
        return posX;
    }

    public static void setPosY(int num)
    {
        posY = num;
    }

    public static int getPosY()
    {
        return posY;
    }

    public static boolean isInCorner()
    {
        return (posX == 9 && posY == 9) || (posX == 0 && posY == 0) || (posX == 9 && posY == 0) || (posX == 0 && posY == 9);
    }

    public static boolean isOnEdge()
    {
        return ((posX == 9) || (posX == 0) || (posY == 9) || (posY == 0));
    }

    public static void addWeapon(Items add)
    {
        if (!inventory.containsKey(add.getWeaponID()))
        {
            inventory.put(add.getWeaponID(), add);
            setPower(getPower() + add.getWeaponPower());
            JOptionPane.showMessageDialog(new JFrame(), "You picked up the " + add.getWeapon());
        }
        else
        {
            JOptionPane.showMessageDialog(new JFrame(), "The " + add.getWeapon() + " is already in your inventory!");
        }
    }

    public static boolean attack(Goblin goblin)
    {
        JOptionPane.showMessageDialog(new JFrame(), "Attack initiated!", "Attack", JOptionPane.WARNING_MESSAGE);
        boolean done = false, attacked = false;
        while (!done)
        {
            boolean valid = false;
            String[] choices = {"Attack", "Use Mushroom", "Use Bomb", "Use Potion"};
            int choice = JOptionPane.showOptionDialog(new JFrame(), "How do you want to attack?", "Your turn",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

            if (choice != 0)
            {
                choice += 2;
            }

            for (int input : inventory.keySet()) {
                if (input == choice) {
                    valid = true;
                    break;
                }
            }
            int randNum;
            switch (choice) {
                case 0:
                    randNum = (int)((Math.random() * (getPower())) + 0);
                    goblin.setHealth(goblin.getHealth() - randNum);
                    if (goblin.getHealth() > 0)
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "The Human attacked the Goblin! Goblin's health: " + goblin.getHealth(), "Attacked", JOptionPane.WARNING_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "The Human attacked the Goblin and killed him!", "Attacked", JOptionPane.WARNING_MESSAGE);
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
                            JOptionPane.showMessageDialog(new JFrame(), "The Human healed himself with a Healing mushroom!");
                            inventory.remove(choice);
                            done = true;
                            attacked = true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "The Human's health is already maxed out!", "Max Health", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "The Healing Mushroom isn't in your inventory", "No Healing Mushroom", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 4:
                    if (valid) {
                        randNum = (int) ((Math.random() * (inventory.get(choice).getWeaponPower())) + 0);
                        goblin.setHealth(goblin.getHealth() - randNum);
                        if (goblin.getHealth() > 0) {
                            JOptionPane.showMessageDialog(new JFrame(), "The Human attacked the Goblin with a bomb! Goblin's health: " + goblin.getHealth(), "Attacked", JOptionPane.WARNING_MESSAGE);
                            setPower(getPower() - inventory.get(choice).getWeaponPower());
                            inventory.remove(choice);
                        } else {
                            setPower(getPower() - inventory.get(choice).getWeaponPower());
                            inventory.remove(choice);
                            JOptionPane.showMessageDialog(new JFrame(), "The Human attacked the Goblin with a bomb and killed him!", "Attacked", JOptionPane.WARNING_MESSAGE);
                        }
                        attacked = true;
                        done = true;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "The Bomb is not in your inventory!", "No Bomb", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 5:
                    if (valid) {
                        if (goblin.getHealth() >= 25) {
                            goblin.setHealth(goblin.getHealth() - inventory.get(choice).getHealingAmount());
                            setHealth(getHealth() + inventory.get(choice).getHealingAmount());
                            inventory.remove(choice);
                            JOptionPane.showMessageDialog(new JFrame(), "The Human took 25 of Goblin's health points to add to his own!", "Attacked", JOptionPane.WARNING_MESSAGE);
                        } else {
                            int health = goblin.getHealth();
                            goblin.setHealth(0);
                            setHealth(getHealth() + health);
                            inventory.remove(choice);
                            JOptionPane.showMessageDialog(new JFrame(), "The Human took the rest of Goblin's health, add to his own, and killed the Goblin", "Attacked", JOptionPane.WARNING_MESSAGE);
                        }
                        attacked = true;
                        done = true;
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "The Potion is not in your inventory!", "No Potion", JOptionPane.WARNING_MESSAGE);
                        System.out.println("\nThe Potion is not in your inventory!\n");
                        break;
                    }
                    break;
                }
        }
        return attacked;
    }

    public static boolean heal()
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
                JOptionPane.showMessageDialog(new JFrame(), "The Human healed himself with a Healing mushroom!");
            }
            else
            {
                JOptionPane.showMessageDialog(new JFrame(), "The Human's health is already maxed out!", "Max Health", JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(new JFrame(), "The Healing Mushroom isn't in your inventory", "No Healing Mushroom", JOptionPane.WARNING_MESSAGE);
        }
        return healed;
    }

    public String toString()
    {
        return "H";
    }

    public Human()
    {
        addWeapon(new Items(1));
        addWeapon(new Items(3));
        addWeapon(new Items(4));
        addWeapon(new Items(5));
    }
}
