package game.entities;
import utilities.Point;


/**
 * The {@code IMobileEntity} interface represents an entity that can move and has a location.
 */
public interface IMobileEntity {

    /**
     * Moves the entity based on the provided friction.
     *
     * @param friction the friction factor that affects the movement of the entity
     */
    void move(double friction);

    /**
     * Returns the current location of the entity.
     *
     * @return the current location of the entity as a {@code Point}
     */

    Point getLocation();

}
