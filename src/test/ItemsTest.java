import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemsTest {

    Items item;

    @BeforeEach
    void setup(){item = new Items(1);}

    @Test
    void setWeapon()
    {
        item.setWeapon(1);
        assertEquals("Sword", item.getWeapon(), "setWeapon() for name failed");
        assertEquals(1, item.getWeaponID(), "setWeapon() for ID failed");
    }

    @Test
    void getWeapon()
    {
        item.setWeapon(2);
        String test = item.getWeapon();
        assertEquals("Crossbow", test, "getWeapon() failed");
    }

    @Test
    void setWeaponPower()
    {
        item.setWeaponPower(0);
        assertEquals(50, item.getWeaponPower(), "setWeaponPower() failed");
    }

    @Test
    void getWeaponPower()
    {
        item.setWeaponPower(4);
        int test1 = item.getWeaponPower();
        assertEquals(100, test1, "getWeaponPower() failed");
    }

    @Test
    void setHealingAmount()
    {
        item.setHealingAmount(3);
        assertEquals(50, item.getHealingAmount(), "setHealingAmount() failed");
    }

    @Test
    void getHealingAmount()
    {
        item.setHealingAmount(5);
        int test2 = item.getHealingAmount();
        assertEquals(25, test2, "getHealingAmount() failed");
    }

    @Test
    void getWeaponID()
    {
        item.setWeapon(0);
        int test3 = item.getWeaponID();
        assertEquals(0, test3, "getWeaponID() failed");
    }

    @AfterEach
    void teardown()
    {

    }
}
