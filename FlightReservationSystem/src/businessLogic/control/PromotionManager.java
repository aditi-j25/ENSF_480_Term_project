package businessLogic.control;

import businessLogic.entity.PromotionObserver;
import java.util.ArrayList;
import java.util.List;

/**
 * <<control>>
 * Singleton + Observer Pattern
 * Manages promotional notifications to subscribed customers
 */
public class PromotionManager {
    private static PromotionManager instance;
    private List<PromotionObserver> subscribers;

    // Private constructor for Singleton
    private PromotionManager() {
        subscribers = new ArrayList<>();
    }

    // Singleton getInstance
    public static synchronized PromotionManager getInstance() {
        if (instance == null) {
            instance = new PromotionManager();
        }
        return instance;
    }

    /**
     * Subscribe a customer to promotional notifications
     */
    public void subscribe(PromotionObserver observer) {
        if (!subscribers.contains(observer)) {
            subscribers.add(observer);
            System.out.println("Subscriber added. Total subscribers: " + subscribers.size());
        }
    }

    /**
     * Unsubscribe a customer from promotional notifications
     */
    public void unsubscribe(PromotionObserver observer) {
        subscribers.remove(observer);
        System.out.println("Subscriber removed. Total subscribers: " + subscribers.size());
    }

    /**
     * Send promotional message to all subscribers
     * This would be called on the first day of each month
     */
    public void notifyAllSubscribers(String promotionMessage) {
        System.out.println("Sending promotion to " + subscribers.size() + " subscribers...");
        for (PromotionObserver observer : subscribers) {
            observer.receivePromotion(promotionMessage);
        }
    }

    /**
     * Simulate monthly promotion (for demonstration)
     */
    public void sendMonthlyPromotion() {
        String message = "🎉 MONTHLY SPECIAL: Get 20% off on all domestic flights! " +
                "Book now and save big. Offer valid until end of month.";
        notifyAllSubscribers(message);
    }

    /**
     * Get number of current subscribers
     */
    public int getSubscriberCount() {
        return subscribers.size();
    }
}