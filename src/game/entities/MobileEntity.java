package game.entities;

/**
 * The {@code MobileEntity} class represents an entity that can move,
 * with properties for acceleration, speed, and maximum speed.
 */

abstract public class MobileEntity extends Entity implements IMobileEntity{

    private final double maxSpeed;
    private double acceleration;
    private double speed;

    /**
     * Constructs a new {@code MobileEntity} with the specified acceleration and maximum speed.
     * The initial speed is set to 0.
     *
     * @param acceleration the acceleration of the mobile entity
     * @param maxSpeed the maximum speed of the mobile entity
     */

    public MobileEntity(double acceleration , double maxSpeed)
    {
        super();
        this.maxSpeed=maxSpeed;
        this.acceleration=acceleration;
        this.speed=0;

    }

    /**
     * Returns the maximum speed of the mobile entity.
     *
     * @return the maximum speed of the mobile entity
     */

    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Returns the acceleration of the mobile entity.
     *
     * @return the acceleration of the mobile entity
     */

    public double getAcceleration() {
        return acceleration;
    }

    /**
     * Returns the current speed of the mobile entity.
     *
     * @return the current speed of the mobile entity
     */


    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the mobile entity.
     *
     * @param speed the new speed of the mobile entity
     */

    public void setSpeed(double speed) {
        this.speed = speed;
    }


    /**
     * Sets the acceleration of the mobile entity.
     *
     * @param acceleration the new acceleration of the mobile entity
     */
    public void setAcceleration(double acceleration)
    {
        this.acceleration = acceleration;
    }


}


