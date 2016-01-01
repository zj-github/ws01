package a28.day3;

import java.lang.reflect.Method;

public interface Advice {
	void beforeMethod(Method method);
	void afterMethod(Method method);
}
