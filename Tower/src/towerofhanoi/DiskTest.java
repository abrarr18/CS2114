// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abrar Islam (abrarr18)
package towerofhanoi;

/**
 * This is class tests Disk class
 * 
 * @author Abrar Islam (abrarr18)
 * @version 2020.10.20
 *
 */

public class DiskTest extends student.TestCase {
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;
    private Disk disk4;
    private Disk disk5;

    /**
     * sets up the fields for test
     */
    public void setUp() {
        disk1 = new Disk(10);
        disk2 = new Disk(10);
        disk3 = new Disk(30);
        disk4 = new Disk(5);
        disk5 = null;
    }


    /**
     * This method tests comparesTo method
     */
    public void testCompareTo() {
        assertEquals(-1, disk1.compareTo(disk3));
        assertEquals(1, disk1.compareTo(disk4));
        assertEquals(0, disk1.compareTo(disk2));
        Exception exception = null;
        try {
            disk1.compareTo(disk5);

        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);

    }


    /**
     * This test method tests toString method
     */
    public void testToString() {
        assertEquals("10", disk1.toString());

    }


    /**
     * This test method tests equal()
     */
    public void testEquals() {
        assertTrue(disk1.equals(disk2));
        assertFalse(disk1.equals(disk3));
        assertFalse(disk2.equals(disk5));
        assertFalse(disk2.equals("String"));

    }

}
