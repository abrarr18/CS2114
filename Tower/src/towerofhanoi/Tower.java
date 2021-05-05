// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abrar Islam (abrarr18)
package towerofhanoi;

/**
 * This is Tower class
 * 
 * @author Abrar Islam (abrarr18)
 * @version 2020.10.20
 *
 */
public class Tower extends LinkedStack<Disk> {
    private Position position;

    /**
     * Constructor of Tower class
     * 
     * @param position
     *            receives position as parameter to work with
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * This method is Position method
     * 
     * @return position
     */
    public Position position() {
        return position;

    }


    /**
     * This method pushes a disk on tower
     * 
     * @param disk
     *            Receives disk as parameter to work with
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        else if (isEmpty()) {
            super.push(disk);
        }

        else if (disk.compareTo(this.peek()) < 0) {
            super.push(disk);

        }
        else {
            throw new IllegalStateException();
        }
    }

}
