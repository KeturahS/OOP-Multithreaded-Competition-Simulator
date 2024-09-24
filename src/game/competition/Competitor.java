package game.competition;

import game.entities.IMobileEntity;
import game.entities.sportsman.Sportsman;
import utilities.Point;

/**
 * The Competitor interface represents an entity that can participate in a competition.
 * It extends the IMobileEntity interface.
 */

public interface Competitor extends IMobileEntity {

    /**
     * Initializes the competitor for a race.
     * This method should set the initial state of the competitor at the beginning of the race.
     */

    public void initRace();
    /**
     * Sets the location of the competitor.
     *
     * @param point the new location of the competitor as a Point object.
     */
    public void setLocation(Point point);
    /**
     * Creates and returns a clone of this competitor.
     *
     * @return a new Sportsman object that is a clone of this competitor.
     */
    public Sportsman clone();
}
