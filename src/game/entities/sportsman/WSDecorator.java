package game.entities.sportsman;


/**
 * The {@code WSDecorator} class is an abstract decorator class that implements the {@link IWinterSportsman} interface.
 * It serves as a base class for decorating or modifying {@link WinterSportsman} objects.
 *
 * <p>This class uses the decorator design pattern to extend the functionality of existing winter sportsman objects.</p>
 */

public abstract class WSDecorator implements IWinterSportsman{

    /**
     * The {@link IWinterSportsman} instance being decorated.
     */

    protected IWinterSportsman specialIWinterSportsman;

    /**
     * Constructs a {@code WSDecorator} with the specified {@link IWinterSportsman} instance.
     *
     * <p>This constructor initializes the decorator with a specific winter sportsman object that will be extended or modified
     * by the decorator.</p>
     *
     * @param iWinterSportsman The {@link IWinterSportsman} instance to be decorated.
     */

    public WSDecorator(IWinterSportsman iWinterSportsman)
    {
        this.specialIWinterSportsman=iWinterSportsman;
    }


    /**
     * Updates the attributes of the decorated winter sportsman.
     *
     * <p>This method delegates the update operation to the decorated {@link IWinterSportsman} instance.</p>
     *
     * @return The updated {@link WinterSportsman} instance.
     */
    public WinterSportsman updateWinterSportsman( )
    {
        return specialIWinterSportsman.updateWinterSportsman();

    }


}
