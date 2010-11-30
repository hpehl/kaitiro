package name.pehl.kaitiro.rebind;

import java.io.PrintWriter;

import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JGenericType;
import com.google.gwt.core.ext.typeinfo.JTypeParameter;
import com.google.gwt.uibinder.rebind.IndentedWriter;

/**
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
public class EventCreator
{
    // -------------------------------------------------------- private members

    protected final GeneratorContext context;
    protected final JGenericType eventInterface;
    protected final JClassType eventSourceType;
    protected final String implName;
    protected final TreeLogger logger;


    // ----------------------------------------------------------- constructors

    /**
     * Construct a new instance of this class
     * 
     * @param context
     * @param eventInterface
     * @param implName
     * @param logger
     * @throws UnableToCompleteException
     */
    public EventCreator(GeneratorContext context, JClassType eventInterface, String implName, TreeLogger logger)
            throws UnableToCompleteException
    {
        this.context = context;
        this.implName = implName;
        this.logger = logger;

        // Check type parameter
        if (!(eventInterface instanceof JGenericType))
        {
            die("The Event must have a type paramter");
        }
        this.eventInterface = (JGenericType) eventInterface;
        JTypeParameter[] typeParameters = this.eventInterface.getTypeParameters();
        if (typeParameters == null || typeParameters.length != 1)
        {
            die("The Event must have a type paramter");
        }
        this.eventSourceType = typeParameters[0];
    }


    // --------------------------------------------------------- create methods

    /**
     * Creates the code for the event implementation. Therefore the following
     * methods are called:
     * <ol>
     * <li>{@link #createPackage(IndentedWriter)}
     * <li>{@link #createImports(IndentedWriter)}
     * <li>{@link #createClass(IndentedWriter)}
     * </ol>
     * 
     * @throws UnableToCompleteException
     */
    public void create() throws UnableToCompleteException
    {
        PrintWriter printWriter = context.tryCreate(logger, eventInterface.getPackage().getName(), implName);
        if (printWriter != null)
        {
            IndentedWriter writer = new IndentedWriter(printWriter);

            createPackage(writer);
            writer.newline();

            createImports(writer);
            writer.newline();

            createClass(writer);
            writer.newline();

            context.commit(logger, printWriter);
        }
    }


    /**
     * Creates the package declaration.
     * 
     * @param writer
     * @throws UnableToCompleteException
     */
    private void createPackage(IndentedWriter writer) throws UnableToCompleteException
    {
        String packageName = eventInterface.getPackage().getName();
        if (packageName.length() > 0)
        {
            writer.write("package %s;", packageName);
        }
    }


    /**
     * Adds some common import statements.
     * 
     * @param writer
     * @throws UnableToCompleteException
     */
    private void createImports(IndentedWriter writer) throws UnableToCompleteException
    {
        writer.write("import com.google.gwt.core.client.GWT;");
    }


    /**
     * Creates the reader class. Therefore the following methods are called:
     * <ol>
     * <li>{@link #createMemberVariables(IndentedWriter)}
     * <li>{@link #createConstructor(IndentedWriter)}
     * <li>{@link #createMethods(IndentedWriter)}
     * </ol>
     * 
     * @param writer
     * @throws UnableToCompleteException
     */
    private void createClass(IndentedWriter writer) throws UnableToCompleteException
    {
        writer.write("public class %s implements %s {", implName, eventInterface.getQualifiedSourceName());
        writer.indent();

        createMemberVariables(writer);
        writer.newline();

        createConstructor(writer);
        writer.newline();

        createMethods(writer);
        writer.newline();

        writer.outdent();
        writer.write("}");
    }


    /**
     * Declares the member variables.
     * 
     * @param writer
     */
    private void createMemberVariables(IndentedWriter writer) throws UnableToCompleteException
    {
    }


    /**
     * Creates a public no-arg constructor. The body of the constructor is
     * created by {@link #createConstructorBody(IndentedWriter)}.
     * 
     * @param writer
     * @throws UnableToCompleteException
     */
    private void createConstructor(IndentedWriter writer) throws UnableToCompleteException
    {
        writer.write("public %s() {", implName);
        writer.indent();
        createConstructorBody(writer);
        writer.outdent();
        writer.write("}");
    }


    /**
     * Creates the constructor body.
     * 
     * @param writer
     */
    private void createConstructorBody(IndentedWriter writer) throws UnableToCompleteException
    {
    }


    /**
     * Generated the necessary methods by calling the following methods:
     * <ol>
     * <li>{@link #createFireMethod(IndentedWriter)}
     * </ol>
     * 
     * @param writer
     * @throws UnableToCompleteException
     */
    private void createMethods(IndentedWriter writer) throws UnableToCompleteException
    {
        createFireMethod(writer);
        writer.newline();
    }


    private void createFireMethod(IndentedWriter writer)
    {
        writer.write("public void fire(%s event) {", eventSourceType.getQualifiedSourceName());
        writer.indent();
        writer.write("// NYI");
        writer.outdent();
        writer.write("}");

    }


    // --------------------------------------------------------- helper methods

    /**
     * Post an error message and halt processing. This method always throws an
     * {@link UnableToCompleteException}
     */
    public void die(String message) throws UnableToCompleteException
    {
        logger.log(TreeLogger.ERROR, message);
        throw new UnableToCompleteException();
    }


    /**
     * Post an error message and halt processing. This method always throws an
     * {@link UnableToCompleteException}
     */
    public void die(String message, Object... params) throws UnableToCompleteException
    {
        logger.log(TreeLogger.ERROR, String.format(message, params));
        throw new UnableToCompleteException();
    }
}
