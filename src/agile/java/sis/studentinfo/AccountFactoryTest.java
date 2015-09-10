package agile.java.sis.studentinfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class AccountFactoryTest extends TestCase {
	//page 401
	private List<Method> updateMethods;
	private List<Method> readOnlyMethods;

	protected void setUp() throws Exception{
		updateMethods = new ArrayList<Method>();
		addUpdateMethod("setBankAba", String.class);
		addUpdateMethod("setBankAccountNumber", String.class);
		addUpdateMethod("setBankAccountType", Account.BankAccountType.class);
		addUpdateMethod("transferFromBank", BigDecimal.class);
		addUpdateMethod("credit", BigDecimal.class);

		readOnlyMethods = new ArrayList<Method>();
		addReadOnlyMethod("getBalance");
		addReadOnlyMethod("transactionAverage");
	}

	private void addUpdateMethod(String name, Class<Object> paramClass)
			throws Exception {
		updateMethods.add(
				Accountable.class.getDeclaredMethod(name, paramClass));
	}

	private void addReadOnlyMethod(String name) {
		Class<?>[] noParams = new Class[] {};
		readOnlyMethods.add(
				Accountable.class.getDeclaredMethod(name, noParams));
	}

	public void testUpdateAccess() throws Exception {
		Accountable account = AccountFactory.create(Permission.UPDATE);
		for (Method method: readOnlyMethods)
			verifyException(PermissionException.class, method, account);

		for (Method method: updateMethods)
			verifyNoException(method, account);
	}

	private void verifyException(
			Class<?> exceptionType, Method method, Object object)
			throws Exception {
		try {
			method.invoke(object, nullParamsFor(method));
			fail("expected exception");
		}
		catch (InvocationTargetException e) {
			assertEquals("expected exception",
					exceptionType, e.getCause().getClass());
		}
	}

	private void verifyNoException(Method method, Object object)
			throws Exception {
		try {
			method.invoke(object, nullParamsFor(method));
		}
		catch (InvocationTargetException e) {
			assertFalse("unexpected exception",
					PermissionException.class = e.getCause().getClass());
		}
	}

	private Object nullParamsFor(Method method) {
		return new Object[method.getParameterTypes().length];
	}

}
