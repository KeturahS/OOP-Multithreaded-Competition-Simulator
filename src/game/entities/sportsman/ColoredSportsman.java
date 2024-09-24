package game.entities.sportsman;
/**
 * The ColoredSportsman class represents a decorator for a WinterSportsman, adding color to the sportsman.
 * It extends the WSDecorator class to modify the appearance of the WinterSportsman with a specified color.
 */
public class ColoredSportsman extends WSDecorator
{

    private String colour;
    /**
     * Constructs a ColoredSportsman with the specified color and underlying WinterSportsman.
     *
     * @param colour          the color to apply to the WinterSportsman, must not be null
     * @param iWinterSportsman the underlying WinterSportsman to be decorated, must not be null
     * @throws IllegalArgumentException if colour is null or iWinterSportsman is null
     */
    public ColoredSportsman(String colour,IWinterSportsman iWinterSportsman)
    {
        super(iWinterSportsman);
        this.colour=colour;
    }
    /**
     * Updates the appearance of the underlying WinterSportsman to include the specified color.
     * This method delegates the update to the underlying WinterSportsman after applying the color change.
     *
     * @return the updated WinterSportsman with color applied
     */



    public WinterSportsman updateWinterSportsman(  )
    {
        changeColour();
        return specialIWinterSportsman.updateWinterSportsman();

    }
    /**
     * Changes the color of the underlying WinterSportsman.
     * This method modifies the appearance of the WinterSportsman by applying the specified color.
     */
    public void changeColour()
    {

        ((WinterSportsman)specialIWinterSportsman).upgrade(colour);
    }


}
