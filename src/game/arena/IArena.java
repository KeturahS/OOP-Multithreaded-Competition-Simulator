package game.arena;

import game.entities.IMobileEntity;

/**
 * The IArena interface represents an arena where competitions or events take place.
 * It defines methods to retrieve friction information and check if a mobile entity has finished.
 */
public interface IArena extends ArenaType {

    /**
     * Retrieves the friction coefficient of the arena.
     *
     * @return the friction coefficient of the arena
     */
    public double getFriction();

    /**
     * Checks if the specified mobile entity has finished its activity in the arena.
     *
     * @param me the mobile entity to check
     * @return true if the mobile entity has finished, false otherwise
     */
    public boolean isFinished(IMobileEntity me);

    /**
     * Retrieves the length of the arena.
     *
     * @return the length of the arena.
     */

    public double getLength();





}
