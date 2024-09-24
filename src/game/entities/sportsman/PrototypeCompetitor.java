package game.entities.sportsman;

/**
 * The {@code PrototypeCompetitor} class provides functionality for creating new competitors
 * by modifying an existing {@link WinterSportsman} instance.
 * <p>This class includes a method to customize a copied sportsman by applying additional attributes.</p>
 */

public class PrototypeCompetitor {

    /**
     * Creates a new competitor by upgrading the specified {@link WinterSportsman} with a new colour.
     * This method modifies the {@code copiedSportsman} instance by setting its colour to the specified value.
     *
     * @param copiedSportsman the {@link WinterSportsman} instance to be modified
     * @param colour the new colour to apply to the {@code copiedSportsman}
     */
    public void makeNewCompetitor(WinterSportsman copiedSportsman, String colour) {
        copiedSportsman.upgrade(colour);
    }
}
