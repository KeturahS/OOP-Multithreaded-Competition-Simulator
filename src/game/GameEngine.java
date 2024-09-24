package game;

import game.competition.Competition;
import game.competition.Competitor;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Snowboarder;


public class GameEngine {

    private static GameEngine instance = null;

    protected GameEngine()
    {

    }

    public static GameEngine getInstance()
    {
        if(instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }


    public void startRace(Competition competition)
    {

        int size=competition.getActiveCompetitors().size();

        for(int i=0; i<size; i++)
        {
            Competitor competitor1= competition.getActiveCompetitors().get(i);
            competitor1.initRace();

        }
        int stepsAmount = 0;

        while(competition.hasActiveCompetitors()) {

            competition.playTurn();
            stepsAmount++;
        }
        System.out.println("race finished in "+stepsAmount+" steps");

        printResults(competition);
    }


    public void printResults(Competition competition)
    {
        System.out.println("Race results:");
        int num=1;

        for(int i=0; i<competition.getFinishedCompetitors().size(); i++)
        {
            String className= competition.getFinishedCompetitors().get(i).getClass().getName();

            if(className.equals("game.entities.sportsman.Skier"))
            {
                System.out.println(num+". "+"Skier "+ ((Skier)competition.getFinishedCompetitors().get(i)).getName());
            }

            if(className.equals("Snowboarder"))
            {
                System.out.println(num+". "+"Snowboarder "+ ((Snowboarder)competition.getFinishedCompetitors().get(i)).getName());
            }

            num++;

        }


    }
}
