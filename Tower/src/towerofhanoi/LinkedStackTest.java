// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abrar Islam (abrarr18)
package towerofhanoi;

/**
 * This class tests LinkedStack class
 * 
 * @author Abrar Islam (abrarr18)
 * @version 2020.10.20
 *
 */
public class LinkedStackTest extends student.TestCase {
    private LinkedStack lnds;

    /**
     * Sets up the fields for test
     */
    public void setUp() {
        lnds = new LinkedStack();
        lnds.push("Mango");
        lnds.push("Apple");
        lnds.push("Orange");

    }


    /**
     * This method tests size()
     */
    public void testSize() {
        assertEquals(3, lnds.size());
        lnds.pop();
        assertEquals(2, lnds.size());
    }


    /**
     * This method tests isEmpty()
     */
    public void testIsEmpty() {
        assertFalse(lnds.isEmpty());
        lnds.clear();
        assertTrue(lnds.isEmpty());

    }


    /**
     * This method tests peek()
     */
    public void testPeek() {
        assertEquals("Orange", lnds.peek());
        lnds.pop();
        assertEquals("Apple", lnds.peek());
        lnds.clear();
        Exception exception = null;
        try {
            lnds.peek();

        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * This method tests pop()
     */
    public void testPop() {
        assertEquals("Orange", lnds.pop());
        lnds.clear();
        Exception exception = null;
        try {
            lnds.pop();

        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * This method tests toString()
     */
    public void testToString() {
        assertEquals("[Orange, Apple, Mango]", lnds.toString());

    }

}
