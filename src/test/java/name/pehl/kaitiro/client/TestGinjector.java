package name.pehl.kaitiro.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
@GinModules(TestModule.class)
public interface TestGinjector extends Ginjector
{
    TestGinjector INJECTOR = GWT.create(TestGinjector.class);


    TestSender getTestSender();
}
