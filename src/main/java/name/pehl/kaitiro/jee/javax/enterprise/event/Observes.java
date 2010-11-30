package javax.enterprise.event;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Identifies the event parameter of an observer method.
 * 
 * @author $Author:$
 * @version $Date:$ $Revision:$
 */
@Target(value = PARAMETER)
@Retention(value = RUNTIME)
@Documented
public @interface Observes
{

}
