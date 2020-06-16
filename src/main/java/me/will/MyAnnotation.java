package me.will;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 런타임
@Target({ElementType.TYPE, ElementType.FIELD}) // 위치 제한 => 타입하고 필드에만 가능
@Inherited // 상속이 가능
public @interface MyAnnotation {

	String name() default "will";

	int number();

	String value() default "value"; // @MyAnnotation("will")

}
