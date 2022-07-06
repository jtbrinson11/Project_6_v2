import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoblinTest {

    Goblin goblin;

    @BeforeEach
    void setup(){goblin = new Goblin(5, 4);}

    @Test
    void setHealth()
    {
        goblin.setHealth(21);
        assertEquals(21, goblin.getHealth(), "setHealth() failed");
    }

    @Test
    void getHealth()
    {
        goblin.setHealth(19);
        int test = goblin.getHealth();
        assertEquals(19, test, "getHealth() failed");
    }

    @Test
    void setPower()
    {
        goblin.setPower(17);
        assertEquals(17, goblin.getPower(), "setPower() failed");
    }

    @Test
    void getPower()
    {
        goblin.setPower(15);
        int test1 = goblin.getPower();
        assertEquals(15, test1, "getPower() failed");
    }

    @Test
    void setPosX()
    {
        goblin.setPosX(7);
        assertEquals(7, goblin.getPosX(), "setPosX() failed");
    }

    @Test
    void getPosX()
    {
        goblin.setPosX(5);
        int test2 = goblin.getPosX();
        assertEquals(5, test2, "getPosX() failed");
    }

    @Test
    void setPosY()
    {
        goblin.setPosY(3);
        assertEquals(3, goblin.getPosY(), "setPosY() failed");
    }

    @Test
    void getPosY()
    {
        goblin.setPosY(1);
        int test3 = goblin.getPosY();
        assertEquals(1, test3, "getPosY() failed");
    }

    @AfterEach
    void teardown()
    {

    }
}
