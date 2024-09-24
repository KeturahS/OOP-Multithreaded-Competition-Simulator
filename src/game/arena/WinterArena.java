package game.arena;

import game.entities.IMobileEntity;
import game.enums.SnowSurface;
import game.enums.WeatherCondition;

import java.util.Objects;

/**
 * The WinterArena class represents an arena used for winter sports events.
 * It implements the IArena interface and provides methods to manage and inspect the arena's properties.
 */

public class WinterArena implements IArena {

    private final double length;
    private final SnowSurface surface;
    private final WeatherCondition condition;


    /**
     * Constructs a WinterArena with the specified length, snow surface, and weather condition.
     *
     * @param length    the length of the winter arena, must be positive
     * @param surface   the snow surface of the arena, must not be null
     * @param condition the weather condition of the arena, must not be null
     * @throws IllegalArgumentException if length is not positive, surface is null, or condition is null
     */
    public WinterArena(double length, SnowSurface surface, WeatherCondition condition)
    {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        if (surface == null) {
            throw new IllegalArgumentException("Surface cannot be null");
        }
        if (condition == null) {
            throw new IllegalArgumentException("Weather condition cannot be null");
        }
        this.length=length;
        this.surface=surface;
        this.condition=condition;


    }


    public String TypeArena()
    {
        return "WinterArena";
    }


    /**
     * Retrieves the friction coefficient of the snow surface in the arena.
     *
     * @return the friction coefficient of the snow surface
     */

    @Override
    public double getFriction() {

        return surface.getFriction();
    }

    /**
     * Checks if the specified mobile entity has finished its activity in the arena.
     *
     * @param me the mobile entity to check
     * @return true if the mobile entity has finished, false otherwise
     */
    @Override
    public boolean isFinished(IMobileEntity me) {

        if(me.getLocation().getY()>=length)
        {
            return true;
        }
        return false;

    }
    /**
     * Retrieves the length of the arena.
     *
     * @return the length of the arena.
     */

    public double getLength()
    {return length;}


    /**
     * Returns a string representation of the WinterArena.
     *
     * @return a string representation of the WinterArena
     */
    @Override
    public String toString() {
        return "WinterArena{" +
                "length=" + length +
                ", surface=" + surface +
                ", condition=" + condition +
                '}';
    }

    /**
     * Checks if this WinterArena is equal to another object.
     * Two WinterArena objects are considered equal if they have the same length, surface, and condition.
     *
     * @param obj the object to compare this WinterArena against
     * @return true if the given object represents a WinterArena equivalent to this WinterArena, false otherwise
     */

    @Override
    public boolean equals(Object obj) {
        boolean ans = false;
        if (obj instanceof WinterArena) {

            ans= Double.compare(((WinterArena) obj).length, length) == 0 &&
                    Objects.equals(surface, ((WinterArena) obj).surface) &&
                    Objects.equals(condition, ((WinterArena) obj).condition);
        }

        return ans;

}}


