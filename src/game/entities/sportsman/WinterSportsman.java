package game.entities.sportsman;

import game.competition.*;
import game.enums.Discipline;
import game.enums.Gender;
import utilities.*;

import java.util.Objects;
import java.util.Random;
import java.util.Vector;

import javax.swing.*;

import static java.lang.Thread.sleep;

/**
 * The {@code WinterSportsman} class represents an athlete participating in winter sports.
 * It extends the {@link Sportsman} class and implements the {@link Competitor} interface.
 * It also implements {@link Runnable}, {@link Cloneable}, and {@link IWinterSportsman}.
 * <p>This class encapsulates attributes related to winter sportsmen, including their state, unique number,
 * and color. It supports functionality such as state management, observer pattern notifications,
 * and cloning.</p>
 */

public class WinterSportsman extends Sportsman implements Competitor, Runnable, Cloneable, IWinterSportsman{


    private JPanel guiComponent;


    private Vector<Observer> list = new Vector<Observer>();
    private final int Unique_num;
    private String colour;
    private static int num = 1;

    private AlertStateContext state;
    private String newState;

    private double stateChangeLocation;

    private long changeStateTime;


    /**
     * Constructs a new {@code WinterSportsman} with the specified attributes.
     *
     * @param guiComponent  the GUI component associated with this sportsman
     * @param name          the name of the sportsman
     * @param age           the age of the sportsman
     * @param gender        the gender of the sportsman
     * @param acceleration  the acceleration of the sportsman
     * @param maxSpeed      the maximum speed of the sportsman
     * @param discipline    the discipline of the sportsman, must not be null
     * @throws IllegalArgumentException if discipline is null
     */
    public WinterSportsman(JPanel guiComponent, String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline discipline)
    {
        super(name, age, gender, acceleration, maxSpeed);

        this.guiComponent = guiComponent;

        if (discipline == null) {
            throw new IllegalArgumentException("Discipline cannot be null");
        }

        this.discipline=discipline;

        this.Unique_num = num;
        num++;


        if (Objects.equals(gender.toString(), "FEMALE")) {
            colour = "Pink";
        } else {
            colour = "Blue";
        }


        state= new AlertStateContext();

        Random rnd= new Random();

        String[] options = {"injured", "disabled", "active"};

        Random random = new Random();
        int index = random.nextInt(options.length);
        newState= options[index];


        stateChangeLocation= random.nextDouble(0,500);


        state.setState(new active());

    }

    /**
     * Updates the attributes of this {@code WinterSportsman}.
     *
     * @return this {@code WinterSportsman} instance
     */
    public WinterSportsman updateWinterSportsman()
    {
        return this;

    }

    /**
     * Adds the specified amount to the acceleration of this {@code WinterSportsman}.
     *
     * @param amount the amount to add to the acceleration
     */

    public void addAcceleration(double amount)
    {
        setAcceleration(getAcceleration()+amount);
    }

    /**
     * Creates a copy of this {@code WinterSportsman}.
     *
     * @return a new {@code WinterSportsman} instance with the same attributes
     */

    public WinterSportsman clone()
    {
        return new WinterSportsman(guiComponent ,getName(), getAge(), getGender(), getAcceleration(), getMaxSpeed(), getDiscipline());

    }

    /**
     * Retrieves the state change location for this {@code WinterSportsman}.
     *
     * @return the state change location
     */

    public double getStateChangeLocation()
    {
        return stateChangeLocation;
    }

    /**
     * Retrieves the new state of this {@code WinterSportsman}.
     *
     * @return the new state
     */
    public String getNewState()
    {return newState;}

    /**
     * Retrieves the alert state context for this {@code WinterSportsman}.
     *
     * @return the alert state context
     */

    public AlertStateContext getState()
    {
        return state;
    }

    /**
     * Sets the new state of this {@code WinterSportsman}.
     *
     * @param S the new state
     */
    public void setNewState(String S)
    {
        newState=S;

    }
    /**
     * Retrieves the color of this {@code WinterSportsman}.
     *
     * @return the color
     */

    public String getColour()
    {return colour;}

    /**
     * Retrieves the unique number of this {@code WinterSportsman}.
     *
     * @return the unique number
     */

    public int getUnique_num()
    {

        return Unique_num;
    }

    /**
     * Updates the color of this {@code WinterSportsman}.
     *
     * @param colour the new color
     */
    public void upgrade(String colour)
    {
        this.colour=colour;

    }

    /**
     * Sets the change state time for this {@code WinterSportsman}.
     *
     * @param time the change state time
     */
    public void setChangeStateTime(long time)
    {
        changeStateTime=time;
    }

    /**
     * Retrieves the change state time for this {@code WinterSportsman}.
     *
     * @return the change state time
     */
    public long getChangeStateTime()
    {
        return changeStateTime;
    }


    /**
     * Retrieves the list of observers for this WinterSportsman.
     *
     * @return a Vector containing the observers of this WinterSportsman
     */


    public Vector<Observer> getObservers()
    {
        return list;

    }

    /**
     * Registers an observer to receive updates from this WinterSportsman.
     *
     * @param l the observer to be registered
     */

    public void registerObserver(Observer l)
    {
        list.add(l);
    }

    /**
     * Unregisters an observer from receiving updates from this WinterSportsman.
     * If the observer is not found, no action is taken.
     *
     * @param l the observer to be unregistered
     */

    public synchronized void unregisterObserver(Observer l) {
        int index = list.indexOf(l);
        list.set(index, list.lastElement());
        list.remove(list.size()-1);

    }


    /**
     * Notifies all registered observers with the current location of this WinterSportsman.
     *
     * @param point the current location of the WinterSportsman
     */
    public void notifyObservers(Point point)
    {
        for(Observer ob : list)
            ob.UpdateCompetition(this, point);

    }


    /**
     * Executes the run method for this WinterSportsman.
     * Continuously updates the location of the WinterSportsman and notifies observers
     * until the WinterSportsman reaches the end of the arena.
     * Updates the GUI by revalidating and repainting the component.
     */

    public void run()
    {
        if(!getObservers().isEmpty())
        {

           int gap=50;

            while(getLocation().getY() < getObservers().getFirst().get_arena_length() && !Objects.equals(getState().alert(), "disabled") && !Objects.equals(getState().alert(), "injured") )
            {
                changeStateTime=0;
                int time = 30;
                try {
                    sleep(time);
                } catch (InterruptedException e) {
                    System.out.println("Got an exception");
                }

                if(getLocation().getY()>gap && getLocation().getY()<gap+50) {
                    SwingUtilities.invokeLater(() -> getObservers().getFirst().getGUI().getCanvas().revalidate());
                    SwingUtilities.invokeLater(() -> getObservers().getFirst().getGUI().getCanvas().repaint());
                    gap+=50;

                }

                notifyObservers(new Point(getLocation().getX(), getLocation().getY()));
            }

            if(!Objects.equals(state.alert(), "disabled"))
            {
                setLocation(new Point(getLocation().getX(), getObservers().getFirst().get_arena_length()));

            }

            SwingUtilities.invokeLater(() -> getObservers().getFirst().getGUI().getCanvas().revalidate());
            SwingUtilities.invokeLater(() -> getObservers().getFirst().getGUI().getCanvas().repaint());



        }
    }

    private final Discipline discipline;


    /**
     * Constructs a new WinterSportsman with the specified attributes.
     *
     * @param name         the name of the sportsman
     * @param age          the age of the sportsman
     * @param gender       the gender of the sportsman
     * @param acceleration the acceleration of the sportsman
     * @param maxSpeed     the maximum speed of the sportsman
     * @param discipline   the discipline of the sportsman, must not be null
     * @throws IllegalArgumentException if discipline is null
     */



    /**
     * Initializes the race for the sportsman by setting the location to 0 and the speed to 0.
     */

    @Override
    public void initRace() {
        super.getLocation().set_y(0);
        super.setSpeed(0);
    }

    /**
     * Gets the discipline of the sportsman.
     *
     * @return the discipline of the sportsman
     */

    public Discipline getDiscipline() {
        return discipline;
    }

    /**
     * Returns a string representation of the WinterSportsman.
     *
     * @return a string representation of the WinterSportsman
     */

    public String toString() {
        return  "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", gender=" + getGender() +
                ", acceleration=" + getAcceleration() +
                ", maxSpeed=" + getMaxSpeed() +
                ", discipline=" + getDiscipline() +
                '}';
    }



}
