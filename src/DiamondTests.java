import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DiamondTests {

    @Test
    public void createInstance() {
        assertNotNull(new Diamond(3).draw());
    }

    @Test
    public void checkHeight(){
        for (int i=1; i <= 9; i += 2) assertEquals(i, new Diamond(i).draw().split("\n").length);
    }


    @Test(expected = IllegalArgumentException.class)
    public void IAEIsThrownOnEvenHeight() {
        new Diamond(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void IAEIsThrownOnNegativeHeight() {
        new Diamond(-3);
    }
    @Test
    public void checkWidth(){
        for (int i=1; i <= 9; i += 2){
            for (String line : new Diamond(i).draw().split("\n")) assertEquals(i, line.length());
        }
    }

    @Test
    public void checkFirstAndLastLine(){
        assertEquals(" o ", new Diamond(3).draw().split("\n")[0]);
        assertEquals(" o ", new Diamond(3).draw().split("\n")[2]);
        assertEquals("  o  ", new Diamond(5).draw().split("\n")[0]);
        assertEquals("  o  ", new Diamond(5).draw().split("\n")[4]);
    }

    @Test
    public void checkOtherLine(){
        assertEquals("o o", new Diamond(3).draw().split("\n")[1]);
        assertEquals(" o o ", new Diamond(5).draw().split("\n")[1]);
        assertEquals("o   o", new Diamond(5).draw().split("\n")[2]);
        assertEquals(" o o ", new Diamond(5).draw().split("\n")[3]);
    }
}