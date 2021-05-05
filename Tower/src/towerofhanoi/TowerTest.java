// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abrar Islam (abrarr18)
package towerofhanoi;
/**
 * This class tests Tower class 
 * 
 * @author Abrar Islam (abrarr18)
 * @version 2020.10.20
 *
 */
public class TowerTest extends student.TestCase {

    private Tower tower;
    private Tower empty;

    /**
     * Set up tests
     */
    public void setUp() {
        this.tower = new Tower(Position.RIGHT);
        this.empty = new Tower(Position.DEFAULT);
    }


    /**
     * Test Tower postion method
     */
    public void testPosition() {
        assertEquals(this.tower.position(), Position.RIGHT);
        assertEquals(this.empty.position(), Position.DEFAULT);

    }


    /**
     * Tests Tower push method
     */
    public void testPush() {
        Exception exception = null;
        try {
            this.tower.push(null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        this.tower.push(new Disk(4));
        this.tower.push(new Disk(2));

        exception = null;
        try {
            this.tower.push(new Disk(6));
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalStateException);
    }
}
