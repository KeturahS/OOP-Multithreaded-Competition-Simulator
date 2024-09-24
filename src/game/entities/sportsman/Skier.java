package game.entities.sportsman;

import game.competition.SkiCompetition;
import game.enums.Discipline;
import game.enums.Gender;

import javax.swing.*;
import java.util.Objects;

import static java.lang.Thread.sleep;


/**
 * The Skier class represents a skier participating in a winter sports competition.
 * It extends the WinterSportsman class.
 */
public class Skier extends WinterSportsman
{

    /**
     * Constructs a new Skier with the specified attributes.
     *
     * @param name         the name of the skier
     * @param age          the age of the skier
     * @param gender       the gender of the skier
     * @param acceleration the acceleration of the skier
     * @param maxSpeed     the maximum speed of the skier
     * @param discipline   the discipline of the skier, must not be null
     * @throws IllegalArgumentException if discipline is null
     */

    public Skier(JPanel guiComponent, String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline discipline)
    {
        super(guiComponent,name, age, gender, acceleration, maxSpeed, discipline);
    }


    /**
     * Returns a string representation of the Skier.
     *
     * @return a string representation of the Skier
     */
    public String toString() {
        return "Skier{" + super.toString();
    }

    /**
     * Compares this skier to the specified object. The result is true if and only if the argument is not null and is a Skier object
     * that has the same age, acceleration, max speed, name, gender, and discipline as this skier.
     *
     * @param obj the object to compare this skier against
     * @return true if the given object represents a Skier equivalent to this skier, false otherwise
     */
    @Override
    public boolean equals(Object obj) {

        boolean ans = false;
        if (obj instanceof Skier)
        {
             Skier skier = (Skier) obj;
             ans = (Double.compare(skier.getAge(), getAge()) == 0 &&
                    Double.compare(skier.getAcceleration(), getAcceleration()) == 0 &&
                    Double.compare(skier.getMaxSpeed(), getMaxSpeed()) == 0 &&
                    Objects.equals(getName(), skier.getName()) &&
                    getGender() == skier.getGender() &&
                    getDiscipline() == skier.getDiscipline());
        }

        return ans;

    }





}
