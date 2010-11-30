package name.pehl.kaitiro.client;

import java.util.Date;

import javax.enterprise.event.Event;

import com.google.inject.Inject;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public class TestSender
{
    @Inject
    Event<TestEvent> event;


    public void fireTestEvent()
    {
        event.fire(new TestEvent("Current time is " + new Date()));
    }
}
