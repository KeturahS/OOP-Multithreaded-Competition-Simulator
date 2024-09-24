package game.competition;

import javax.swing.*;
/**
 * The SkiCompetitionBuilder interface defines methods for constructing a SkiCompetition.
 * Implementing classes should provide concrete implementations for building the arena,
 * creating the list of competitors, and retrieving the constructed SkiCompetition.
 */
public interface SkiCompetitionBuilder {
    /**
     * Builds the arena for the skiing competition.
     * This method should initialize and configure the arena where the competition will take place.
     */
    public void buildArena();
    /**
     * Builds the list of competitors for the skiing competition.
     * This method should create and add a specified number of competitors to the competition.
     *
     * @param n            the number of competitors to be added to the competition.
     * @param guiComponent the JPanel component where the competition will be displayed.
     */
    public void buildCompetitorsList(int n, JPanel guiComponent);
    /**
     * Retrieves the constructed SkiCompetition.
     *
     * @return the SkiCompetition object constructed by this builder.
     */
    public SkiCompetition getSkiCompetition();


}
