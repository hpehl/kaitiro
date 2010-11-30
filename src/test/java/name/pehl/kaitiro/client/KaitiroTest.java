package name.pehl.kaitiro.client;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public class KaitiroTest extends GWTTestCase
{
    @Override
    public String getModuleName()
    {
        return "name.pehl.kaitiro.KaitiroTest";
    }


    public void testKaitiro()
    {
        TestSender testSender = TestGinjector.INJECTOR.getTestSender();
        testSender.fireTestEvent();
    }
}
