package game.entities.sportsman;

import game.entities.MobileEntity;
import game.enums.Gender;
import game.enums.League;
import utilities.Point;

import java.util.Objects;


/**
 * The {@code Sportsman} class represents a sportsman with properties such as name, age, and gender.
 * This class extends {@code MobileEntity} and includes additional methods and properties.
 */

public class Sportsman extends MobileEntity  {

    private final String name;
    private final double age;
    private final Gender gender;


    /**
     * Constructs a new {@code Sportsman} with the specified name, age, gender, acceleration, and maximum speed.
     *
     * @param name         the name of the sportsman
     * @param age          the age of the sportsman
     * @param gender       the gender of the sportsman
     * @param acceleration the acceleration of the sportsman
     * @param maxSpeed     the maximum speed of the sportsman
     */

    public Sportsman(String name, double age, Gender gender, double acceleration, double maxSpeed) {
        super(acceleration, maxSpeed);


        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be null");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive");
        }
        this.name = name;
        this.age = age;
        this.gender = gender;


    }



    // אולי כדאי ליצור פונקציה שתעדכן את המספר הייחודי
    /**
     * Moves the sportsman based on the provided friction and calculates the new position.
     *
     * @param friction the friction factor that affects the movement of the sportsman
     */
    public void move(double friction)
    {
        double bonus= League.calcAccelerationBonus(((this.getAge())));

        if (getSpeed() < getMaxSpeed()) {
           setSpeed(Math.min(getSpeed() + (getAcceleration() + bonus) * friction, getMaxSpeed()));
        }
        Point newPoint= new Point(getLocation().getX(), getLocation().getY()+getSpeed());


        setLocation(newPoint);

    }




    /**
     * Returns the current location of the sportsman.
     *
     * @return the current location of the sportsman as a {@code Point}
     */

    public Point getLocation()
    {
        return super.getLocation();


    }

    public void setLocation(Point point)
    {
        super.setLocation(point);

    }

    /**
     * Retrieves the gender of the person.
     *
     * @return the gender of the person
     */

    public Gender getGender() {
        return gender;
    }

    /**
     * Retrieves the age of the person.
     *
     * @return the age of the person
     */
    public double getAge() {
        return age;
    }


    /**
     * Retrieves the name of the person.
     *
     * @return the name of the person
     */
    public String getName()
    {
        return name;
    }





}
