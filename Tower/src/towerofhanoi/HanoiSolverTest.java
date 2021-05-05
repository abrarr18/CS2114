// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abrar Islam (abrarr18)
package towerofhanoi;
/**
 * This class tests HanoiSolver class
 * 
 * @author Abrar Islam (abrarr18)
 * @version 2020.10.20
 *
 */
public class HanoiSolverTest extends student.TestCase {
    private HanoiSolver hanoi1;
    private HanoiSolver hanoi2;
    private HanoiSolver empty;

    /**
     * Set up method tests
     */
    public void setUp() {
        this.hanoi1 = new HanoiSolver(5);
        for (int i = 5; i > 0; i--) {
            this.hanoi1.getTower(Position.RIGHT).push(new Disk(i));
        }

        this.hanoi2 = new HanoiSolver(5);
        this.hanoi2.getTower(Position.LEFT).push(new Disk(5));
        this.hanoi2.getTower(Position.LEFT).push(new Disk(2));
        this.hanoi2.getTower(Position.MIDDLE).push(new Disk(1));
        this.hanoi2.getTower(Position.RIGHT).push(new Disk(5));
        this.hanoi2.getTower(Position.RIGHT).push(new Disk(2));

        this.empty = new HanoiSolver(0);
    }


    /**
     * Test HanoiSolver disks method
     */
    public void testDisks() {
        assertEquals(this.hanoi1.disks(), 5, 0.01);
    }


    /**
     * Test HanoiSolver getTower method
     */
    public void testGetTower() {
        Tower tower = hanoi1.getTower(Position.DEFAULT);
        Disk disk = new Disk(5);
        tower.push(disk);
        assertEquals("[5]", tower.toString());
    }


    /**
     * Test HanoiSolver toString method
     */
    public void testToString() {
        assertEquals(this.hanoi1.toString(), "[][][1, 2, 3, 4, 5]");
        this.hanoi1.solve();
        assertEquals(this.hanoi1.toString(), "[1, 2, 3, 4, 5][][]");

        assertEquals(this.hanoi2.toString(), "[2, 5][1][2, 5]");
        assertEquals(this.empty.toString(), "[][][]");
    }

}
