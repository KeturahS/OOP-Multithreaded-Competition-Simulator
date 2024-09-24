package game.entities.sportsman;

/**
 * The {@code IWinterSportsman} interface defines the contract for winter sportsman objects
 * that can be updated. It represents a general interface for winter sportsman entities
 * that may have additional features or attributes added dynamically.
 */
public interface IWinterSportsman
{
    /**
     * Updates the current {@link WinterSportsman} instance. This method allows modifications
     * or enhancements to be applied to the winter sportsman.
     *
     * @return the updated {@link WinterSportsman} instance
     */
    WinterSportsman updateWinterSportsman();

}
