package javax.enterprise.event;

/**
 * An interface for firing events of a particular type, and registering
 * observers for events of that type.
 * 
 * @param <T>
 *            the type of the event object
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public interface Event<T>
{
    /**
     * Fires an event with the specified qualifiers and notifies observers.
     * 
     * @param event
     *            the event object
     */
    void fire(T event);
}
