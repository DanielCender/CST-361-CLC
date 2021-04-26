package business;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
* This service Bean executes before a method runs where it is injected into the application.
*
* @author  Alex Zoller, Crystal Sciarrino, Daniel Cender
* @version 1.0
* @since   2021-04-25 
*/
public class LoggingInterceptor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@AroundInvoke 
	public Object methodInterceptor(InvocationContext ctx) throws Exception 
	{ 
	System.out.println("******************* Intercepting call to method: " +  
	ctx.getTarget().getClass() + "." + ctx.getMethod().getName() + "()"); 
	return ctx.proceed(); 
	} 
}
