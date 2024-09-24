package game.entities.sportsman;

import game.enums.Discipline;
import game.enums.Gender;

import javax.swing.*;
import java.util.Objects;

/**
 * The Snowboarder class represents a snowboarder participating in a winter sports competition.
 * It extends the WinterSportsman class.
 */

public class Snowboarder extends WinterSportsman{
    /**
     * Constructs a new Snowboarder with the specified attributes.
     *
     * @param name         the name of the snowboarder
     * @param age          the age of the snowboarder
     * @param gender       the gender of the snowboarder
     * @param acceleration the acceleration of the snowboarder
     * @param maxSpeed     the maximum speed of the snowboarder
     * @param discipline   the discipline of the snowboarder, must not be null
     * @throws IllegalArgumentException if discipline is null
     */

    public Snowboarder(JPanel guiComponent, String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline discipline)
    {
        super(guiComponent, name, age, gender, acceleration,maxSpeed, discipline);


    }

    /**
     * Returns a string representation of the Snowboarder.
     *
     * @return a string representation of the Snowboarder
     */
    public String toString() {
        return "Snowboarder{" + super.toString();

    }

    /**
     * Compares this snowboarder to the specified object. The result is true if and only if the argument is not null and is a Snowboarder object
     * that has the same age, acceleration, max speed, name, gender, and discipline as this snowboarder.
     *
     * @param obj the object to compare this snowboarder against
     * @return true if the given object represents a Snowboarder equivalent to this snowboarder, false otherwise
     */
    public boolean equals(Object obj) {

        boolean ans = false;
        if (obj instanceof Snowboarder)
        {
            Snowboarder snowboarder = (Snowboarder) obj;
            ans = (Double.compare(snowboarder.getAge(), getAge()) == 0 &&
                    Double.compare(snowboarder.getAcceleration(), getAcceleration()) == 0 &&
                    Double.compare(snowboarder.getMaxSpeed(), getMaxSpeed()) == 0 &&
                    Objects.equals(getName(), snowboarder.getName()) &&
                    getGender() == snowboarder.getGender() &&
                    getDiscipline() == snowboarder.getDiscipline());
        }

        return ans;

    }

}
