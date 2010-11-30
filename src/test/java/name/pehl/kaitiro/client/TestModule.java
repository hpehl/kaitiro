package name.pehl.kaitiro.client;

import com.google.gwt.inject.client.AbstractGinModule;

/**
 * @author $LastChangedBy$
 * @version $LastChangedRevision$
 */
public class TestModule extends AbstractGinModule
{
    @Override
    protected void configure()
    {
        bind(TestSender.class);
        bind(TestListener.class);
    }
}
