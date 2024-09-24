package game.competition;

import game.arena.IArena;
import game.arena.WinterArena;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Snowboarder;
import game.entities.sportsman.Sportsman;
import game.entities.sportsman.WinterSportsman;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;
import utilities.GUIcompetition;

import java.util.ArrayList;
import java.util.Objects;

/**
 * The SkiCompetition class represents a skiing competition held in a winter arena.
 * It extends the WinterCompetition class and defines methods specific to skiing competitions.
 */

public class SkiCompetition extends WinterCompetition implements CompetitionPlan {

    /**
     * Constructs a new SkiCompetition with the specified attributes.
     *
     * @param arena         the arena where the skiing competition takes place, must not be null
     * @param maxCompetitors the maximum number of skiers allowed in the competition, must be positive
     * @param discipline    the discipline of the skiing competition, must not be null
     * @param league        the league of the skiing competition, must not be null
     * @param gender        the gender of the skiers in the competition, must not be null
     * @throws IllegalArgumentException if arena is null, maxCompetitors is not positive, discipline is null, or league is null
     */
    public SkiCompetition(GUIcompetition gui, WinterArena arena, int maxCompetitors, Discipline discipline, League
            league, Gender gender) {
        super(gui, arena, maxCompetitors, discipline, league, gender);

    }
    /**
     * Constructs a new SkiCompetition with default attributes.
     * Initializes the competition with a given GUI component and default settings.
     *
     * @param gui the GUI component managing the competition's display
     */

    public SkiCompetition(GUIcompetition gui)
    {
        super();
        RACE_FINISHED=false;
        NUMBER_OF_FINISHED_RACERS=0;
        GUI=gui;


    }
    /**
     * Sets the arena for the skiing competition.
     *
     * @param arena the WinterArena where the skiing competition will take place
     */

    @Override
    public void setArena(WinterArena arena)
    {
       super.setArena(arena);

    }


    /**
     * Adds a skier competitor to the skiing competition.
     *
     * @param competitor the skier competitor to add
     * @throws IllegalArgumentException if the competitor is not a Skier
     */





    public synchronized void addCompetitor(Competitor competitor) {


        super.addCompetitor(competitor);

        ((WinterSportsman)(competitor)).registerObserver(getGUI());


        if (competitor instanceof Snowboarder)
        {
            throw new IllegalArgumentException("Invalid competitor Snowboarder " + ((Snowboarder) competitor).getName());
        }
    }

    /**
     * Returns a string representation of the SkiCompetition.
     *
     * @return a string representation of the SkiCompetition
     */

    public String toString() {
        return "SkiCompetition{" + super.toString();
    }

    /**
     * Checks if this SkiCompetition is equal to another object.
     * Two SkiCompetition objects are considered equal if they have the same arena, max competitors, discipline, league, and gender.
     *
     * @param obj the object to compare this SkiCompetition against
     * @return true if the given object represents a SkiCompetition equivalent to this SkiCompetition, false otherwise
     */
    public boolean equals(Object obj) {

        boolean ans = false;
        if (obj instanceof SkiCompetition)
        {
            SkiCompetition skiCompetition = (SkiCompetition) obj;
            ans = (skiCompetition.getArena().equals(getArena())
                    && skiCompetition.getMaxCompetitors()==getMaxCompetitors() && skiCompetition.getDiscipline()==getDiscipline()
                    && skiCompetition.getLeague()==getLeague() && skiCompetition.getGender()==getGender());
        }

        return ans;

    }


}