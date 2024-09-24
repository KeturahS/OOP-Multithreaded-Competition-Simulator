package game.competition;

import game.arena.WinterArena;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Snowboarder;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;
import utilities.GUIcompetition;

/**
 * The SnowboardCompetition class represents a snowboarding competition held in a winter arena.
 * It extends the WinterCompetition class and defines methods specific to snowboarding competitions.
 */

public class SnowboardCompetition extends WinterCompetition{

    /**
     * Constructs a new SnowboardCompetition with the specified attributes.
     *
     * @param arena         the arena where the snowboarding competition takes place, must not be null
     * @param maxCompetitors the maximum number of snowboarders allowed in the competition, must be positive
     * @param discipline    the discipline of the snowboarding competition, must not be null
     * @param league        the league of the snowboarding competition, must not be null
     * @param gender        the gender of the snowboarders in the competition, must not be null
     * @throws IllegalArgumentException if arena is null, maxCompetitors is not positive, discipline is null, or league is null
     */
    public SnowboardCompetition(GUIcompetition gui,WinterArena arena, int maxCompetitors, Discipline discipline, League
            league, Gender gender)
    {
        super(gui, arena, maxCompetitors, discipline, league, gender);

    }

    /**
     * Adds a snowboarder competitor to the snowboarding competition.
     *
     * @param competitor the snowboarder competitor to add
     * @throws IllegalArgumentException if the competitor is not a Snowboarder
     */

    public void addCompetitor(Competitor competitor)
    {

        if(competitor instanceof Snowboarder)
        {
            super.addCompetitor(competitor);
            ((Snowboarder)competitor).registerObserver(getGUI());
        }
        if(competitor instanceof Skier)
            throw new IllegalArgumentException("Invalid competitor Skier "+ ((Skier) competitor).getName());

    }

    /**
     * Returns a string representation of the SnowboardCompetition.
     *
     * @return a string representation of the SnowboardCompetition
     */

    public String toString() {
        return "SnowboardCompetition{" + super.toString();
    }

    /**
     * Checks if this SnowboardCompetition is equal to another object.
     * Two SnowboardCompetition objects are considered equal if they have the same arena, max competitors, discipline, league, and gender.
     *
     * @param obj the object to compare this SnowboardCompetition against
     * @return true if the given object represents a SnowboardCompetition equivalent to this SnowboardCompetition, false otherwise
     */

    public boolean equals(Object obj) {

        boolean ans = false;
        if (obj instanceof SnowboardCompetition)
        {
            SnowboardCompetition snowboardCompetition = (SnowboardCompetition) obj;
            ans = (snowboardCompetition.getArena().equals(getArena())
                    && snowboardCompetition.getMaxCompetitors()==getMaxCompetitors() && snowboardCompetition.getDiscipline()==getDiscipline()
                    && snowboardCompetition.getLeague()==getLeague() && snowboardCompetition.getGender()==getGender());
        }

        return ans;

    }


}
