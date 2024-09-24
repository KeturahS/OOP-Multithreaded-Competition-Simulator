package game.competition;

import javax.swing.*;
/**
 * The Engineer class is responsible for directing the construction of a SkiCompetition.
 * It utilizes a SkiCompetitionBuilder to build the competition's components.
 */
public class Engineer
{

    private SkiCompetitionBuilder builder;
    /**
     * Constructs an Engineer with the specified SkiCompetitionBuilder.
     *
     * @param builder the SkiCompetitionBuilder used to construct the SkiCompetition.
     */
    public Engineer(SkiCompetitionBuilder builder)
    {
        this.builder=builder;
    }
    /**
     * Returns the constructed SkiCompetition.
     *
     * @return the SkiCompetition constructed by the builder.
     */
    public SkiCompetition getSkiCompetition()
    {
        return builder.getSkiCompetition();

    }
    /**
     * Directs the construction of the SkiCompetition.
     * This method builds the arena and the list of competitors.
     *
     * @param N            the number of competitors to be added to the competition.
     * @param guiComponent the JPanel component where the competition will be displayed.
     */
    public void constructCompetition(int N, JPanel guiComponent)
    {
        builder.buildArena();
        builder.buildCompetitorsList(N, guiComponent);

    }


}
