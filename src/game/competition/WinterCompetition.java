package game.competition;

import game.arena.IArena;
import game.arena.WinterArena;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Sportsman;
import game.entities.sportsman.WinterSportsman;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;
import utilities.Point;
import utilities.GUIcompetition;
import java.util.ArrayList;
import java.util.Objects;


/**
 * The abstract WinterCompetition class represents a winter sports competition held in an arena.
 * It extends the Competition class and defines methods and properties specific to winter competitions.
 */

public abstract class WinterCompetition extends Competition {


    private Discipline discipline;
    private League league;
    private Gender gender;
    protected boolean RACE_FINISHED;
    protected int NUMBER_OF_FINISHED_RACERS;
    protected GUIcompetition GUI;

    /**
     * Constructs a new WinterCompetition with the specified attributes.
     *
     * @param arena         the arena where the competition takes place, must not be null
     * @param maxCompetitors the maximum number of competitors allowed in the competition, must be positive
     * @param discipline    the discipline of the competition, must not be null
     * @param league        the league of the competition, must not be null
     * @param gender        the gender of the competitors in the competition, must not be null
     * @throws IllegalArgumentException if arena is null, maxCompetitors is not positive, discipline is null, or league is null
     */
    public WinterCompetition(GUIcompetition gui, WinterArena arena, int maxCompetitors, Discipline discipline, League
                    league, Gender gender)
    {
        super(arena,maxCompetitors);
        GUI=gui;

        RACE_FINISHED=false;
        NUMBER_OF_FINISHED_RACERS=0;

        if (discipline == null)
        {
            throw new IllegalArgumentException("Discipline cannot be null");
        }
        if (league == null)
        {
            throw new IllegalArgumentException("League cannot be null");
        }
        this.discipline=discipline;
        this.gender=gender;
        this.league=league;

    }
    /**
     * Constructs a new WinterCompetition with default attributes.
     * Initializes the competition with a given GUI component and default settings.
     *
     */
    public WinterCompetition()
    {
      super();
    }
    /**
     * Retrieves the length of the arena associated with the competition.
     *
     * @return the length of the arena
     */
    public  synchronized double get_arena_length()
    {
        return getArena().getLength();

    }
    /**
     * Retrieves the GUI component managing the competition's display.
     *
     * @return the GUI competition component
     */
    public GUIcompetition getGUI()
    {
        return GUI;
    }



    /**
     * Plays a turn in the winter competition.
     * Moves active competitors based on arena conditions and determines if they have finished.
     */

/*
    public void playTurn(){
        ArrayList<Competitor> tmp = new ArrayList<>(getActiveCompetitors());

        for(Competitor competitor: tmp) // פה
        {
            if(!getArena().isFinished(competitor))
            {
                competitor.move(getArena().getFriction());

                if(getArena().isFinished(competitor))
                {
                    competitor.setLocation(new Point(competitor.getLocation().getX(), get_arena_length()));

                    AddFinishedCompetitor(competitor);

                    getActiveCompetitors().remove(competitor);
                }
            }

        }
    }

    */

    public void playTurn() {
        ArrayList<Competitor> newActiveCompetitors = new ArrayList<>(getActiveCompetitors());


        for (int i = 0; i < newActiveCompetitors.size(); i++) {

            if (getArena().isFinished(newActiveCompetitors.get(i)))
            {
                AddFinishedCompetitor(newActiveCompetitors.get(i));
                newActiveCompetitors.remove(i);
                i--;

            }

            else {
                newActiveCompetitors.get(i).move(getArena().getFriction());
                if (getArena().isFinished(newActiveCompetitors.get(i))) {
                    AddFinishedCompetitor(newActiveCompetitors.get(i));
                    newActiveCompetitors.remove(i);
                    i--;
                }

            }

            setActiveCompetitors(newActiveCompetitors);
        }
    }


    /**
     * Checks if a competitor is valid for this winter competition.
     *
     * @param competitor the competitor to validate
     * @return true if the competitor is valid, false otherwise
     */

    public boolean isValidCompetitor(Competitor competitor)
    {

       if(competitor instanceof WinterSportsman)
       {
           if(league.isInLeague(((WinterSportsman) competitor).getAge())
                    && ((WinterSportsman) competitor).getGender().equals(gender)
                    && ((WinterSportsman) competitor).getDiscipline().equals(discipline))
            {
                return true;

            }

       }
       return false;

    }

    /**
     * Returns a string representation of the WinterCompetition.
     *
     * @return a string representation of the WinterCompetition
     */


    public String toString() {
        return  " arena=" + getArena().getClass().getName() +
                ", maxCompetitors=" + getMaxCompetitors() +
                ", discipline=" + getDiscipline() +
                ", league=" + getLeague() +
                ", gender=" + getGender() +
                '}';
    }

    /**
     * Sets the discipline for the competition.
     *
     * @param discipline the discipline of the competition
     */
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
    /**
     * Sets the gender for the competition.
     *
     * @param gender the gender of the competitors
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    /**
     * Sets the league for the competition.
     *
     * @param league the league of the competition
     */
    public void setLeague(League league) {
        this.league = league;
    }

    /**
     * Returns the gender of the competitors in the competition.
     *
     * @return the gender of the competitors
     */


    public void setRACEFINISHED()
    {
             RACE_FINISHED= true;

    }
    /**
     * Returns the gender of the competitors in the competition.
     *
     * @return the gender of the competitors
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Returns the league of the competition.
     *
     * @return the league of the competition
     */

    public League getLeague() {
        return league;
    }

    /**
     * Returns the discipline of the competition.
     *
     * @return the discipline of the competition
     */
    public Discipline getDiscipline() {
        return discipline;
    }


    /**
     * Updates the competition status based on the current position of the racer.
     *
     * @param racer the WinterSportsman whose position is updated
     * @param point the new position of the racer
     */

    public synchronized void UpdateCompetition( WinterSportsman racer, Point point)
    {
        racer.setLocation(point);


        racer.move(getArena().getFriction());

        if(racer.getLocation().getY()>get_arena_length())
        {
            super.AddFinishedCompetitor(racer);

            super.RemoveCompetitor(racer);
        }

        if(getActiveCompetitors().isEmpty() && !getFinishedCompetitors().isEmpty())
        {
            RACE_FINISHED=true;

        }

    }

    /**
     * Checks if the race has finished.
     *
     * @return true if the race is finished, false otherwise
     */
    public boolean get_if_race_finished()
    {
        return getActiveCompetitors().isEmpty() && !getFinishedCompetitors().isEmpty();
    }



}
