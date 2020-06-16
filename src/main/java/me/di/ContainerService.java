package me.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * 리플랙션 주의사항
 * 1. 지나친 사용은 성능 이슈를 야기할 수 있다. 반드시 필요한 경우에만 사용
 * 2. 컴파일 타임에 확인되지 않고, 런타임 시에 발생하는 문제를 만들 가능성이 있다.
 * 3. 접근 지시자를 무시할 수 있다.
 */

public class ContainerService {

	public static <T> T getObject(Class<T> classType) {
		T instance = createInstance(classType);
		Arrays.stream(classType.getDeclaredFields()).forEach(f -> {
			if (f.getAnnotation(Inject.class) != null) {
				Object fieldInstance = createInstance(f.getType());
				f.setAccessible(true);
				try {
					f.set(instance, fieldInstance);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
		});
		return instance;
	}

	private static <T> T createInstance(Class<T> classType) {
		try {
			return classType.getConstructor(null).newInstance();
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}

}
