package InterfaceAdapters;

import ApplicationBusiness.InputBoundary;

/**
 * The InterfaceAdapters.GameController is a sub-controller that's a part of the
 * InterfaceAdapters.NavigatorController. It's used to tell the entity through the
 * ApplicationBusiness.InputBoundary that a position was clicked
 */

public class GameController {
    private InputBoundary input;

    /**
     * constructs the Game Controller and stores the ApplicationBusiness.InputBoundary for use.
     * @param input
     */
    public GameController(InputBoundary input) {
        this.input = input;
    }

    /**
     * This method is used to tell the use case that which position was clicked,
     * through the ApplicationBusiness.InputBoundary
     * @param i
     */
    public void click(Integer i) {
        this.input.click(i);
    }


}
