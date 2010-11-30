package name.pehl.kaitiro.client;

import javax.enterprise.event.Observes;

import com.google.gwt.core.client.GWT;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public class TestListener
{
    public void listenToTestEvent(@Observes TestEvent testEvent)
    {
        GWT.log("Received test event: " + testEvent.getMessage());
    }
}
