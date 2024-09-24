package game.entities.sportsman;


/**
 * The {@code SpeedySportsman} class is a concrete implementation of the {@link WSDecorator} class.
 * It decorates an existing {@link IWinterSportsman} by adding acceleration capabilities.
 * <p>This class extends the functionality of the decorated {@link IWinterSportsman} by
 * providing additional acceleration.</p>
 */

public class SpeedySportsman extends WSDecorator
{
    private double acceleration;

    /**
     * Constructs a new {@code SpeedySportsman} with the specified acceleration and decorated {@link IWinterSportsman}.
     *
     * @param acceleration the additional acceleration for the sportsman
     * @param iWinterSportsman the {@link IWinterSportsman} to be decorated
     */
    public SpeedySportsman(double acceleration, IWinterSportsman iWinterSportsman)
    {
        super(iWinterSportsman);
        this.acceleration=acceleration;
    }

    /**
     * Updates the decorated {@link IWinterSportsman} by adding acceleration to it.
     * Returns the updated {@link WinterSportsman} with the additional acceleration applied.
     *
     * @return the updated {@link WinterSportsman} instance with added acceleration
     */

    public WinterSportsman updateWinterSportsman(  )
    {
        specialIWinterSportsman.updateWinterSportsman().addAcceleration(acceleration);
        return specialIWinterSportsman.updateWinterSportsman();

    }


}
