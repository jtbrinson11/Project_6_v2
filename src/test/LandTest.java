import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LandTest {

    Land land;

    @BeforeEach
    void setup(){land = new Land("T");}

    @Test
    void setLand()
    {
        land.setLand("J");
        assertEquals("J", land.getLand(), "setLand() failed");
    }

    @Test
    void getLand()
    {
        land.setLand("B");
        String test = land.getLand();
        assertEquals("B", test, "getLand() failed");
    }

    @AfterEach
    void teardown()
    {

    }
}
