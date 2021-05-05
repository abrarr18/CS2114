// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Abrar Islam (abrarr18)
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * This class creates the puzzle window
 * 
 * @author Abrar Islam (abrarr18)
 * @version 2020.10.20
 *
 */
public class PuzzleWindow implements Observer {

    public static final int DISK_HEIGHT = 4;
    private HanoiSolver game;
    private Window window;
    private Shape left;
    private Shape middle;
    private Shape right;
    public static final int WIDTH_FACTOR = 10;
    public static final int DISK_GAP = 1;

    /**
     * Constructor of PuzzleWindow
     * 
     * @param game
     *            receives game as parameter to work
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window();
        window.setTitle("Tower of Hanoi");

        left = new Shape(150, 90, 5, 200, Color.RED);
        middle = new Shape(300, 90, 5, 200, Color.BLUE);
        right = new Shape(450, 90, 5, 200, Color.MAGENTA);

        for (int i = game.disks(); i > 0; i--) {
            Disk d = new Disk(15 * i);
            window.addShape(d);
            game.getTower(Position.RIGHT).push(d);
            moveDisk(Position.RIGHT);

        }
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);

        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.SOUTH);
        solve.onClick(this, "clickedSolve");

    }


    /**
     * This method takes
     * 
     * @param
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position newPos = (Position)arg;
            moveDisk(newPos);
            sleep();
        }
    }


    /**
     * This method takes
     * 
     * @param position
     *            receives position as parameter
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole = null;

        if (position == Position.MIDDLE) {
            currentPole = middle;
        }
        else if (position == Position.LEFT) {
            currentPole = left;
        }
        else {
            currentPole = right;
        }

        int x = currentPole.getX() + (currentPole.getWidth() - currentDisk
            .getWidth()) / 2;
        int y = currentPole.getY() + currentPole.getHeight() - game.getTower(
            position).size() * (DISK_HEIGHT + DISK_GAP);

        currentDisk.moveTo(x, y);

    }


    /**
     * Sleep method
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * This method takes
     * 
     * @param button
     *            creates clickedSolve
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }

}
