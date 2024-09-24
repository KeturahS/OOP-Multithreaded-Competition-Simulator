package game.competition;

import game.arena.IArena;
import game.arena.WinterArena;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Snowboarder;

import java.util.ArrayList;

/**
 * The abstract Competition class represents a competition held in an arena with competitors.
 * It defines methods and properties common to all types of competitions.
 */
abstract public class Competition {

    private  IArena arena;
    private  int maxCompetitors;
    private ArrayList<Competitor> activeCompetitors;
    private ArrayList<Competitor> finishedCompetitors;

    /**
     * Constructs a new Competition with the specified arena and maximum number of competitors.
     *
     * @param arena         the arena where the competition takes place, must not be null
     * @param maxCompetitors the maximum number of competitors allowed in the competition, must be positive
     * @throws IllegalArgumentException if arena is null or if maxCompetitors is not positive
     */
    public Competition(IArena arena,int maxCompetitors)
    {
        if (arena == null)
            {
                throw new IllegalArgumentException("Arena cannot be null");
            }
        if (maxCompetitors <=0)
        {
            throw new IllegalArgumentException("max amount of competitors must be positive");
        }
        this.arena=arena;
        this.maxCompetitors=maxCompetitors;
        this.activeCompetitors= new ArrayList<>();
        this.finishedCompetitors= new ArrayList<>();
    }

    public Competition()
    {
        this.activeCompetitors= new ArrayList<>();
        this.finishedCompetitors= new ArrayList<>();

    }


    public void setArena(WinterArena arena)
    {
        this.arena=arena;
    }

    /**
     * Checks if a competitor is valid for this competition.
     *
     * @param competitor the competitor to validate
     * @return true if the competitor is valid, false otherwise
     */

    abstract public boolean isValidCompetitor(Competitor competitor);

    /**
     * Adds a competitor to the competition.
     *
     * @param competitor the competitor to add
     * @throws IllegalStateException    if the competition arena is full
     * @throws IllegalArgumentException if the competitor is not valid for this competition
     */
    public void addCompetitor(Competitor competitor)
    {
        // Initialize the competitor for the race
        competitor.initRace();

        // Check if the arena is full
        if(!getActiveCompetitors().isEmpty()) {
            if (getActiveCompetitors().size() == getMaxCompetitors()) {
                throw new IllegalStateException("WinterArena is full max = " + maxCompetitors);
            }
        }
        // Check if the competitor is valid for this competition
        if(!isValidCompetitor(competitor))
        {
            if(competitor instanceof Skier)
                throw new IllegalArgumentException("Invalid competitor Skier " + ((Skier) competitor).getName());
            if(competitor instanceof Snowboarder)
                throw new IllegalArgumentException("Invalid competitor Snowboarder " + ((Snowboarder) competitor).getName());
        }
        // Add the competitor to the active competitors list
        activeCompetitors.add(competitor);

    }



    public void setmaxcompetitors(int max)
    {
        maxCompetitors=max;
    }
    /**
     * Returns the maximum number of competitors allowed in the competition.
     *
     * @return the maximum number of competitors
     */

    public int getMaxCompetitors() {
        return maxCompetitors;
    }

    /**
     * Returns the arena where the competition takes place.
     *
     * @return the arena of the competition
     */
    public IArena getArena() {
        return arena;
    }

    /**
     * Abstract method to play a turn in the competition.
     * This method will define the logic of each turn in the specific competition.
     */
    abstract public void playTurn();

    /**
     * Checks if there are active competitors in the competition.
     *
     * @return true if there are active competitors, false otherwise
     */
    public  synchronized boolean hasActiveCompetitors()
    {
        return !activeCompetitors.isEmpty();
    }

    /**
     * Returns the list of active competitors in the competition.
     *
     * @return the list of active competitors
     */

    public synchronized ArrayList<Competitor> getActiveCompetitors() {

        return activeCompetitors;
    }

    /**
     * Returns the list of finished competitors in the competition.
     *
     * @return the list of finished competitors
     */

    public synchronized ArrayList<Competitor> getFinishedCompetitors()
    {
        return finishedCompetitors;
    }

    /**
     * Sets the list of active competitors in the competition.
     *
     * @param activeCompetitors the list of active competitors to set
     */
    public synchronized void setActiveCompetitors(ArrayList<Competitor> activeCompetitors) {
        this.activeCompetitors = activeCompetitors;
    }





    /**
     * Adds a competitor to the list of finished competitors.
     *
     * @param competitor the competitor to add to the list of finished competitors
     */
    public synchronized void AddFinishedCompetitor(Competitor competitor)
    {
        finishedCompetitors.add(competitor);
    }


    /**
     * Removes a competitor from the list of active competitors.
     *
     * @param competitor the competitor to remove
     */
    public synchronized void RemoveCompetitor(Competitor competitor)
    {
        activeCompetitors.remove(competitor);

    }

}

