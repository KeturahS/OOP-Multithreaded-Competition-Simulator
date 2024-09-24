package utilities;


/**
 * The {@code active} class implements the {@link CompetitorAlertState} interface
 * and represents a state where a competitor is active.
 * This class defines the behavior when the competitor is in an active state.
 *
 * <p>This state returns the string "active" when the {@code alert} method is called.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 *     AlertStateContext context = new AlertStateContext();
 *     CompetitorAlertState activeState = new active();
 *     context.setState(activeState);
 *     String alertMessage = activeState.alert(context);
 *     // alertMessage will be "active"
 * </pre>
 *
 * @see CompetitorAlertState
 */

public class active implements CompetitorAlertState
{
    /**
     * Returns the alert message when the competitor is in the active state.
     *
     * @param ctx The context of the alert state.
     * @return The string "active" indicating the competitor is active.
     */

    @Override
    public String alert(AlertStateContext ctx) {

        return "active";
    }
}
