package game.entities;
import utilities.Point;
/**
 * The  {@code Entity} class represents a basic entity with a location in a 2D space.
 */
public abstract class Entity {

    private Point location = new Point();
    /**
     * Default constructor that initializes the location of the entity to (0, 0).
     */


    public Entity()

    {
        location.set_x(0);
        location.set_y(0);

    }
    /**
     * Constructs an entity with a specified location.
     *
     * @param location the initial location of the entity
     */

    public Entity(Point location)
    {
        this.location.set_x(location.getX());
        this.location.set_y(location.getY());

    }

    /**
     * Returns the location of the entity.
     *
     * @return the current location of the entity
     */

    public Point getLocation() {
        return location;
    }

    /**
     * Sets the location of the entity.
     *
     * @param location11 the new location of the entity
     */

    public void setLocation(Point location1)
    {
        this.location.set_x(location1.getX());
        this.location.set_y(location1.getY());
    }
}
