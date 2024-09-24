package game.competition;

import game.arena.WinterArena;
import game.entities.sportsman.WinterSportsman;
import utilities.GUIcompetition;
import utilities.Point;

import javax.swing.*;
/**
 * The Observer interface defines the methods required for observing changes in a competition.
 * Implementing classes will receive updates on competitors' progress and provide access to the competition's GUI components.
 */
public interface Observer {
    /**
     * Updates the observer with the current status of a competitor in the competition.
     *
     * @param RACER the WinterSportsman whose status is being updated.
     * @param point the current location of the competitor.
     */
    public void UpdateCompetition(WinterSportsman RACER, Point point);
    /**
     * Retrieves the length of the arena associated with the competition.
     *
     * @return the length of the arena.
     */
    public double get_arena_length();
    /**
     * Retrieves the GUI component managing the competition's display.
     *
     * @return the GUIcompetition component.
     */
    public GUIcompetition getGUI();
    /**
     * Retrieves the canvas (JPanel) used for rendering the competition's graphical elements.
     *
     * @return the JPanel used as the canvas for the competition.
     */
    public JPanel getCanvas();


}
