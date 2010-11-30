package name.pehl.kaitiro.rebind;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public class EventGenerator extends Generator
{
    /**
     * @param logger
     * @param context
     * @param requestedClass
     * @return
     * @throws UnableToCompleteException
     * @see com.google.gwt.core.ext.Generator#generate(com.google.gwt.core.ext.TreeLogger,
     *      com.google.gwt.core.ext.GeneratorContext, java.lang.String)
     */
    @Override
    public String generate(TreeLogger logger, GeneratorContext context, String requestedClass)
            throws UnableToCompleteException
    {
        JClassType eventIterface = context.getTypeOracle().findType(requestedClass);
        if (eventIterface == null)
        {
            logger.log(TreeLogger.ERROR, String.format("Unable to find metadata for type \"%s\"", requestedClass));
            throw new UnableToCompleteException();
        }

        String implName = eventIterface.getName().replace('.', '_') + "Impl";
        String packageName = eventIterface.getPackage().getName();
        new EventCreator(context, eventIterface, implName, logger).create();
        return packageName + "." + implName;
    }
}
