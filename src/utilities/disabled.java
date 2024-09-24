package utilities;


/**
 * The {@code disabled} class implements the {@link CompetitorAlertState} interface
 * and represents a state where a competitor is disabled.
 * This class defines the behavior when the competitor is in a disabled state.
 *
 * <p>This state returns the string "disabled" when the {@code alert} method is called.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 *     AlertStateContext context = new AlertStateContext();
 *     CompetitorAlertState disabledState = new disabled();
 *     context.setState(disabledState);
 *     String alertMessage = disabledState.alert(context);
 *     // alertMessage will be "disabled"
 * </pre>
 *
 * @see CompetitorAlertState
 */

public class disabled implements CompetitorAlertState{

    /**
     * Returns the alert message when the competitor is in the disabled state.
     *
     * @param ctx The context of the alert state.
     * @return The string "disabled" indicating the competitor is disabled.
     */


    @Override
    public String alert(AlertStateContext ctx)
    {
        return "disabled";
    }
}
