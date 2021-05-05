// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abrar Islam (abrarr18)
package towerofhanoi;

/**
 * This is Project runner class
 * which runs the whole program
 * 
 * @author Abrar Islam (abrarr18)
 * @version 2020.10.20
 *
 */
public class ProjectRunner {
    /**
     * main method of ProjectRunner class
     * 
     * @param args
     *            takes args as parameter
     */
    

    public static void main(String[] args) {
        int disks = 5;

        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver solver = new HanoiSolver(disks);
        PuzzleWindow puzzle = new PuzzleWindow(solver);
    }
}
