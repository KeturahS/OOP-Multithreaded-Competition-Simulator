package game.competition;

import game.arena.ArenaFactory;
import game.arena.ArenaType;
import game.arena.WinterArena;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Sportsman;
import game.entities.sportsman.WinterSportsman;
import game.enums.*;
import utilities.GUIcompetition;

import javax.swing.*;
import java.lang.foreign.Arena;
import java.util.ArrayList;
/**
 * The MyBuilder class implements the SkiCompetitionBuilder interface to construct a SkiCompetition.
 * It is responsible for building the arena and the list of competitors for the competition.
 */
public class MyBuilder implements SkiCompetitionBuilder {

    private SkiCompetition comp;
    /**
     * Constructs a MyBuilder with the specified GUIcompetition.
     * Initializes the SkiCompetition with default gender, league, and discipline.
     *
     * @param gui the GUIcompetition component to be used in the competition.
     */
    public MyBuilder(GUIcompetition gui)
    {
        comp = new SkiCompetition(gui);
        comp.setGender(Gender.MALE);
        comp.setLeague(League.ADULT);
        comp.setDiscipline(Discipline.DOWNHILL);

    }
    /**
     * Builds the WinterArena for the competition using an ArenaFactory.
     * The arena is set with a length of 700, snow surface as CRUD, and weather condition as STORMY.
     */
    public void buildArena()
    {

        ArenaFactory factory= new ArenaFactory();
        WinterArena arena= (WinterArena) factory.getArena("winter", 700, SnowSurface.CRUD, WeatherCondition.STORMY);

        comp.setArena(arena);

    }
    /**
     * Builds the list of competitors for the SkiCompetition.
     * The method creates and adds a specified number of WinterSportsman competitors to the competition.
     *
     * @param N            the number of competitors to be added.
     * @param guiComponent the JPanel component where the competition will be displayed.
     */
    public void buildCompetitorsList(int N, JPanel guiComponent)
    {
        comp.setmaxcompetitors(20);

        WinterSportsman sportsman = new WinterSportsman(guiComponent,"sk1",23, Gender.MALE, 2,2, Discipline.DOWNHILL);


        for(int i=0; i<N; i++)
        {
            WinterSportsman sportsman1= (sportsman).clone();

            comp.addCompetitor(sportsman1);

        }

    }
    /**
     * Returns the constructed SkiCompetition.
     *
     * @return the SkiCompetition constructed by this builder.
     */
    public SkiCompetition getSkiCompetition()
    {
        return comp;
    }



}
