package name.pehl.kaitiro;

import junit.framework.Test;
import junit.framework.TestSuite;
import name.pehl.kaitiro.client.KaitiroTest;

import com.google.gwt.junit.tools.GWTTestSuite;

/**
 * @author $Author$
 * @version $Date$ $Revision: 597
 *          $
 */
public class KaitiroGwtTestSuite extends GWTTestSuite
{
    public static Test suite()
    {
        TestSuite suite = new TestSuite("GWT tests for kaitiro");

        suite.addTestSuite(KaitiroTest.class);

        return suite;
    }
}
