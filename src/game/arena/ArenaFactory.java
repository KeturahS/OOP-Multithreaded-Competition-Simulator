package game.arena;

import game.enums.SnowSurface;
import game.enums.WeatherCondition;
/**
 * Factory class for creating different types of arenas based on the provided parameters.
 */
public class ArenaFactory {
    /**
     * Creates and returns an instance of ArenaType based on the given parameters.
     *
     * @param arenaType The type of arena to create ("winter" or "summer").
     * @param length The length of the arena (applicable for winter arenas).
     * @param surface The snow surface type (applicable for winter arenas).
     * @param condition The weather condition (applicable for winter arenas).
     * @return An instance of ArenaType corresponding to the specified arenaType, or null if the arenaType is not recognized.
     */
    public ArenaType getArena(String arenaType, double length, SnowSurface surface, WeatherCondition condition) {

        ArenaType arenaT = null;

// based on logic factory instantiates an object
        if ("winter".equals(arenaType))
            arenaT = new WinterArena(length, surface, condition);

        else if ("summer".equals(arenaType))
            arenaT = new SummerArena();

        return arenaT;
    }
}
