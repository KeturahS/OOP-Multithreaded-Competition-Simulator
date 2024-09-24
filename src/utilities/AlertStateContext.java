package utilities;

/**
 * The {@code AlertStateContext} class represents the context in which a competitor's alert state is managed.
 * It holds the current state of the competitor and allows the state to be changed and queried.
 *
 * <p>This class is a part of the state design pattern, where the behavior of a competitor alert is determined
 * by the current state.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 *     AlertStateContext context = new AlertStateContext();
 *     CompetitorAlertState activeState = new active();
 *     context.setState(activeState);
 *     String alertMessage = context.alert();
 *     // alertMessage will be "active"
 * </pre>
 *
 * @see CompetitorAlertState
 */


public class AlertStateContext
{
    CompetitorAlertState currentState;

    /**
     * Constructs an {@code AlertStateContext} with no initial state.
     * The state should be set using {@link #setState(CompetitorAlertState)}.
     */
    public AlertStateContext()
    {

    }

    /**
     * Sets the current state of the competitor to the specified state.
     *
     * @param state The new state to be set.
     */
    public void setState(CompetitorAlertState state)
    {
        currentState = state; }


    /**
     * Returns the alert message based on the current state of the competitor.
     *
     * @return The alert message corresponding to the current state.
     */
    public String alert()
    {
       return currentState.alert(this);
    }


}
