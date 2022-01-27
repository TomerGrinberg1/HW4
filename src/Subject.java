/**
 * An interface which represents a general subject (part of the Observer design
 * pattern).
 * all methods will be implemented by the implementor
 */
interface Subject {
    /**
     * adds new subscriber to the notification list
     * @param observer new subscriber
     */
    void addObserver(Observer observer);
    /**
     * remove a subscriber from the notification list
     * @param observer new subscriber
     */
    void removeObserver(Observer observer);
    /**
     * notifies all the observers
     * @param desc  new update
     */
    void notifyObservers(String desc);
}