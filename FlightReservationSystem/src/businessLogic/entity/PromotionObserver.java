package businessLogic.entity;

/**
 * Observer Pattern Interface
 * Implemented by users who want to receive promotional notifications
 */
public interface PromotionObserver {
    /**
     * Called when a new promotion is available
     * @param promotionMessage The promotion message to display
     */
    void receivePromotion(String promotionMessage);
}