// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abrar Islam (abrarr18)
package towerofhanoi;

import java.awt.Color;
import cs2.Shape;
import student.TestableRandom;

/**
 * This is disk class
 * 
 * @author Abrar Islam (abrarr18)
 * @version 2020.10.20
 *
 */
public class Disk extends Shape implements Comparable<Disk> {
    /**
     * Default constructor of Disk class
     * 
     * @param width
     *            receives width as parameter
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom rnd = new TestableRandom();
        int rnd1 = rnd.nextInt(255);
        int rnd2 = rnd.nextInt(255);
        int rnd3 = rnd.nextInt(255);

        Color color = new Color(rnd1, rnd2, rnd3);
        this.setBackgroundColor(color);

    }


    /**
     * This method compares the disks
     * 
     * @param otherDisk
     *            Receives otherDisk to compare
     * @return integer value(1 or -1 or 0)
     */
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        else {
            if (this.getWidth() < otherDisk.getWidth()) {
                return -1;
            }
            else if (this.getWidth() > otherDisk.getWidth()) {
                return 1;
            }
            else {
                return 0;
            }
        }

    }


    /**
     * This method prints out the values
     * 
     * @return string
     */
    public String toString() {
        return "" + this.getWidth();

    }


    

    /**
     * Determine if this Disk is equal to another object
     * 
     * @param obj
     *            Object to compare to
     * @return equality
     */
    public boolean equals(Object obj) {
        boolean areTheyEqual = false;
        if (obj instanceof Disk) {
            Disk otherDisk = (Disk)obj;
            if (this.getWidth() == otherDisk.getWidth()) {
                areTheyEqual = true;
            }
        }
        return areTheyEqual;

    }

}
