import java.util.HashMap;
import javax.swing.*;

public class Goblin{

    HashMap<Integer, Items> inventory = new HashMap<>();

    private int health = 50, power = 135, posX = 0, posY = 0;

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

    public void attack()
    {
        JFrame attacked = new JFrame();
        JOptionPane.showMessageDialog(attacked, "Attack started by Goblin!", "Attacked", JOptionPane.WARNING_MESSAGE);
        boolean done = false;
        while (!done) {
            int choice = ((Math.random() <= 0.5) ? 1 : 2);
            if (choice == 1) {
                Human.setHealth((Human.getHealth()) - (inventory.get(1).getWeaponPower()));
                if (Human.getHealth() <= 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "The Goblin killed the Human with his sword!", "Killed", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(), "The Goblin injured the Human with his sword! Human's health: " + Human.getHealth(), "Injured", JOptionPane.WARNING_MESSAGE);
                }
                done = true;
            }
            else
            {
                if (inventory.size() != 1)
                {
                    int damage = (int)((Math.random() * (inventory.get(1).getWeaponPower())) + 0);
                    Human.setHealth(Human.getHealth() - damage);
                    if (Human.getHealth() <= 0)
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "The Goblin killed the Human with a bomb!", "Killed", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "The Goblin injured the Human with a bomb! Human's health: " + Human.getHealth(), "Injured", JOptionPane.WARNING_MESSAGE);
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
