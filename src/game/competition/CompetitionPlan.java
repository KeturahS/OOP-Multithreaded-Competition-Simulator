package game.competition;

import game.arena.IArena;
import game.arena.WinterArena;

import java.util.ArrayList;
/**
 * The CompetitionPlan interface defines the blueprint for a competition.
 * It includes methods to set the arena where the competition will take place.
 */
public interface CompetitionPlan {
    /**
     * Sets the arena for the competition.
     *
     * @param arena the WinterArena where the competition will be held.
     */
    public void setArena(WinterArena arena);


}
