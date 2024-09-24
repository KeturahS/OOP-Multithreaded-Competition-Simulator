package utilities;


/**
 * The {@code CompetitorAlertState} interface defines the contract for alert states of a competitor.
 * Implementing classes will define specific behavior for different alert states.
 *
 * <p>This interface is part of the state design pattern, where different states of a competitor
 * are represented by different implementations of this interface.</p>
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
 * @see AlertStateContext
 */

public interface CompetitorAlertState {

    /**
     * Returns the alert message for the current state of the competitor.
     *
     * @param ctx The context of the alert state, which provides access to state-related information.
     * @return A string representing the alert message for the current state.
     */
     String alert(AlertStateContext ctx);

}
