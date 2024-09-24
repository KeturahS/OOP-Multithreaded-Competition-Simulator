package utilities;

/**
 * The {@code completed} class implements the {@link CompetitorAlertState} interface
 * and represents a state where a competitor has completed their activity.
 * This class defines the behavior when the competitor is in a completed state.
 *
 * <p>This state returns the string "completed" when the {@code alert} method is called.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 *     AlertStateContext context = new AlertStateContext();
 *     CompetitorAlertState completedState = new completed();
 *     context.setState(completedState);
 *     String alertMessage = completedState.alert(context);
 *     // alertMessage will be "completed"
 * </pre>
 *
 * @see CompetitorAlertState
 */

public class completed implements CompetitorAlertState {

    /**
     * Returns the alert message when the competitor is in the completed state.
     *
     * @param ctx The context of the alert state.
     * @return The string "completed" indicating the competitor has completed their activity.
     */

    @Override
    public String alert(AlertStateContext ctx) {
        return "completed";
    }
}
