package utilities;
/**
 * The {@code injured} class implements the {@link CompetitorAlertState} interface.
 * It represents the state of a competitor being injured.
 *
 * <p>In this state, the competitor is considered to be in an "injured" condition, and this
 * state is represented by returning the string "injured" from the {@code alert} method.</p>
 */

public class injured implements CompetitorAlertState{

    /**
     * Returns the alert message for the injured state.
     *
     * <p>This method provides a string representation of the current state, which in this case
     * indicates that the competitor is injured.</p>
     *
     * @param ctx The context object that may be used to retrieve additional information, though it is not utilized in this method.
     * @return A string representing the injured state, specifically "injured".
     */
    @Override
    public String alert(AlertStateContext ctx)
    {
        return "injured";

    }
}
