package kr.co.saramin.security.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( ElementType.METHOD)  // 메소드 일때 

@Retention( RetentionPolicy.RUNTIME) // 컴파일 말고 런타임때
public @interface Auth {

	
	
	
	
	
}
