import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {

    Human human;

    @BeforeEach
    void setup() {human = new Human();}

    @Test
    void setHealth()
    {
        human.setHealth(77);
        assertEquals(77, human.getHealth(), "setHealth() failed");
    }

    @Test
    void getHealth()
    {
        human.setHealth(88);
        int test = human.getHealth();
        assertEquals(88, test, "getHealth() failed");
    }

    @Test
    void setPower()
    {
        human.setPower(55);
        assertEquals(55, human.getPower(), "setPower() failed");
    }

    @Test
    void getPower()
    {
        human.setPower(15);
        int test1 = human.getPower();
        assertEquals(15, test1, "getPower() failed");
    }

    @Test
    void setPosX()
    {
        human.setPosX(5);
        assertEquals(5, human.getPosX(), "setPosX() failed");
    }

    @Test
    void getPosX()
    {
        human.setPosX(4);
        int test2 = human.getPosX();
        assertEquals(4, test2, "getPosX() failed");
    }

    @Test
    void setPosY()
    {
        human.setPosY(3);
        assertEquals(3, human.getPosY(), "SetPosY() failed");
    }

    @Test
    void getPosY()
    {
        human.setPosY(2);
        int test3 = human.getPosY();
        assertEquals(2, test3, "getPosY() failed");
    }

    @Test
    void isInCorner()
    {
        human.setPosX(9);
        human.setPosY(9);
        assertTrue(human.isInCorner(), "isInCorner() for 9,9 failed");

        human.setPosX(1);
        human.setPosY(5);
        assertFalse(human.isInCorner(), "isInCorner() for 1,5 failed");
    }

    @Test
    void isOnEdge()
    {
        human.setPosX(9);
        assertTrue(human.isOnEdge(), "isOnEdge() for x = 9 failed");

        human.setPosX(8);
        assertFalse(human.isOnEdge(), "isOnEdge() for x = 8 failed");

        human.setPosY(0);
        assertTrue(human.isOnEdge(), "isOnEdge() for y = 0 failed");

        human.setPosY(1);
        assertFalse(human.isOnEdge(), "isOnEdge() for y = 1 failed");
    }

    @AfterEach
    void teardown()
    {

    }
}
